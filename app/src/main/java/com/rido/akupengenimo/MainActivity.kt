package com.rido.akupengenimo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rido.akupengenimo.ui.theme.AkuPengenIMOTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.clickable
import com.rido.akupengenimo.data.local.HeroDataProvider
import com.rido.akupengenimo.data.local.ItemDataProvider
import com.rido.akupengenimo.data.local.Hero
import com.rido.akupengenimo.data.local.Skill
import com.rido.akupengenimo.data.local.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.rido.akupengenimo.data.remote.DraftApiService
import com.rido.akupengenimo.data.remote.HeroRepository

val roles = listOf("All", "Assassin", "Fighter", "Mage", "Marksman", "Tank", "Support")
private val retrofit = Retrofit.Builder()
    .baseUrl("https://gist.githubusercontent.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private val apiService = retrofit.create(DraftApiService::class.java)
private val repository = HeroRepository(apiService)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        HeroDataProvider.loadExtraData(this)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            // STATE UNTUK BOTTOM NAVIGATION (0 = Hero, 1 = Item)
            var selectedTab by remember { mutableStateOf(0) }

            AkuPengenIMOTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    containerColor = MaterialTheme.colorScheme.background,

                    bottomBar = {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            NavigationBarItem(
                                selected = selectedTab == 0,
                                onClick = { selectedTab = 0 },
                                label = { Text("Heroes", fontWeight = FontWeight.Bold) },
                                icon = { Text("🛡️", fontSize = 24.sp) }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 1,
                                onClick = { selectedTab = 1 },
                                label = { Text("Items", fontWeight = FontWeight.Bold) },
                                icon = { Text("⚔️", fontSize = 24.sp) }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 2,
                                onClick = { selectedTab = 2 },
                                label = { Text("Draft", fontWeight = FontWeight.Bold) },
                                icon = { Text("📋", fontSize = 24.sp) }
                            )
                        }
                    }
                ) { innerPadding ->

                    when (selectedTab) {
                        0 -> HeroScreen(
                            modifier = Modifier.padding(innerPadding),
                            snackbarHostState = snackbarHostState
                        )
                        1 -> ItemScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                        2 -> DraftScreen(
                            modifier = Modifier.padding(innerPadding),
                            repository = repository
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroScreen(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("All") }


    val allHeroes = remember { HeroDataProvider.getListHeroes() }

    val filteredHeroes = remember(searchQuery, selectedRole) {
        allHeroes.filter { hero ->
            val matchesSearch = hero.name.contains(searchQuery, ignoreCase = true)
            val matchesRole = if (selectedRole == "All") {
                true
            } else {
                hero.description.contains(selectedRole, ignoreCase = true)
            }
            matchesSearch && matchesRole
        }
    }

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            placeholder = { Text("Search Hero Name") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(roles) { role ->
                FilterChip(
                    selected = (selectedRole == role),
                    onClick = { selectedRole = role },
                    label = { Text(role) }
                )
            }
        }



        LazyColumn {
            items(filteredHeroes) { hero ->
                HeroItem(hero = hero, snackbarHostState = snackbarHostState)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, snackbarHostState: SnackbarHostState) {
    var showDetails by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }


    var showCounterDialog by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()

            .clickable { showCounterDialog = true },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = hero.photoUrl,
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = hero.name, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                    Text(text = hero.description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { showDetails = !showDetails },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = if (showDetails) "Hide Skills" else "Detail Skills", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        scope.launch {
                            isLoading = true
                            delay(1000)
                            isFavorite = !isFavorite
                            isLoading = false
                            val message = if (isFavorite) "${hero.name} added to Favorites" else "${hero.name} removed from Favorites"
                            snackbarHostState.showSnackbar(message)
                        }
                    },
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(modifier = Modifier.size(24.dp), strokeWidth = 2.dp, color = MaterialTheme.colorScheme.primary)
                    } else {
                        Text(text = if (isFavorite) "❤️" else "🤍", fontSize = 24.sp)
                    }
                }
            }

            AnimatedVisibility(visible = showDetails) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Hero Skills:", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp), color = MaterialTheme.colorScheme.secondary)
                    LazyRow(contentPadding = PaddingValues(end = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(hero.skills) { skill ->
                            SkillCard(skill = skill)
                        }
                    }
                }
            }
        }
    }


    if (showCounterDialog) {
        CounterDialog(
            hero = hero,
            onDismiss = { showCounterDialog = false }
        )
    }
}
@Composable
fun SkillCard(skill: Skill) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .height(150.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(12.dp)
                .verticalScroll(scrollState) /
        ) {
            Text(
                text = skill.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = skill.description,
                style = MaterialTheme.typography.bodySmall,
                lineHeight = 16.sp
            )
        }
    }
}


@Composable
fun ItemScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }


    val allItems = remember { ItemDataProvider.getListItems() }

    val filteredItems = remember(searchQuery) {
        allItems.filter { item ->
            item.name.contains(searchQuery, ignoreCase = true) ||
                    item.category.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = { Text("Search Item Name or Category") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        LazyColumn {
            items(filteredItems) { item ->
                ItemCard(item = item)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                model = item.photoUrl,
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = item.category,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(bottom = 4.dp)
                )


                val scrollState = rememberScrollState()

                Box(modifier = Modifier
                    .heightIn(max = 100.dp)
                    .verticalScroll(scrollState)
                ) {
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 18.sp
                    )
                }
            }
        }
    }
}
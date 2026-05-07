package com.rido.akupengenimo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rido.akupengenimo.ui.theme.AkuPengenIMOTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            
            AkuPengenIMOTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    HeroScreen(
                        modifier = Modifier.padding(innerPadding),
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}

@Composable
fun HeroScreen(modifier: Modifier = Modifier, snackbarHostState: SnackbarHostState) {
    val heroes = getListHeroes()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Mobile Legends Heroes",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp),
            color = MaterialTheme.colorScheme.primary
        )
        
        LazyColumn {
            items(heroes) { hero ->
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
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = hero.photoUrl,
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = hero.photo),
                    error = painterResource(id = hero.photo),
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = hero.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = hero.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { showDetails = !showDetails },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = if (showDetails) "Hide Skills" else "Detail Skills",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                IconButton(
                    onClick = {
                        scope.launch {
                            isLoading = true
                            delay(2000)
                            isFavorite = !isFavorite
                            isLoading = false
                            
                            val message = if (isFavorite) "${hero.name} ditambahkan ke Favorit" else "${hero.name} dihapus dari Favorit"
                            snackbarHostState.showSnackbar(message)
                        }
                    },
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Text(
                            text = if (isFavorite) "❤️" else "🤍",
                            fontSize = 24.sp
                        )
                    }
                }
            }

            AnimatedVisibility(visible = showDetails) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Hero Skills:",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        color = MaterialTheme.colorScheme.secondary
                    )
                    LazyRow(
                        contentPadding = PaddingValues(end = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(hero.skills) { skill ->
                            SkillCard(skill = skill)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SkillCard(skill: Skill) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = skill.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = skill.description,
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 16.sp
            )
        }
    }
}

private fun getListHeroes(): List<Hero> {
    val lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore."
    
    return listOf(
        Hero(
            "Tigreal", "Tank - Crowd Control", 
            "https://img.esportsku.com/wp-content/uploads/2022/04/tigreal-revamped-mobile-legends-1536x864.jpg",
            R.drawable.tigreal,
            listOf(
                Skill("Skill 1: Attack Wave", lorem),
                Skill("Skill 2: Sacred Hammer", lorem),
                Skill("Ultimate: Implosion", lorem)
            )
        ),
        Hero(
            "Miya", "Marksman - Attack Speed", 
            "https://media.esports.gg/uploads/2025/04/Miya-ML-968x544.jpg",
            R.drawable.miya,
            listOf(
                Skill("Skill 1: Moon Arrow", lorem),
                Skill("Skill 2: Arrow of Eclipse", lorem),
                Skill("Ultimate: Hidden Moonlight", lorem)
            )
        ),
        Hero(
            "Balmond", "Fighter - True Damage", 
            "https://i.pinimg.com/originals/20/29/ec/2029ec56a2dc5b069e35fe2f9958701c.jpg",
            R.drawable.balmond,
            listOf(
                Skill("Skill 1: Soul Lock", lorem),
                Skill("Skill 2: Cyclone Sweep", lorem),
                Skill("Ultimate: Lethal Counter", lorem)
            )
        ),
        Hero(
            "Layla", "Marksman - Long Range", 
            "https://wallpapercave.com/wp/wp8966953.jpg",
            R.drawable.layla,
            listOf(
                Skill("Skill 1: Malefic Bomb", lorem),
                Skill("Skill 2: Void Projectile", lorem),
                Skill("Ultimate: Destruction Rush", lorem)
            )
        ),
        Hero(
            "Zilong", "Fighter/Assassin - Burst", 
            "https://img.esportsku.com/wp-content/uploads/2020/11/zilong.jpg",
            R.drawable.zilong,
            listOf(
                Skill("Skill 1: Spear Flip", lorem),
                Skill("Skill 2: Spear Strike", lorem),
                Skill("Ultimate: Supreme Warrior", lorem)
            )
        )
    )
}

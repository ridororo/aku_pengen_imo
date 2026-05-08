package com.rido.akupengenimo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rido.akupengenimo.data.remote.HeroDraft
import com.rido.akupengenimo.data.remote.HeroRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DraftScreen(modifier: Modifier = Modifier, repository: HeroRepository) {
    var allHeroes by remember { mutableStateOf<List<HeroDraft>>(emptyList()) }
    var allies by remember { mutableStateOf(List<HeroDraft?>(5) { null }) }
    var enemies by remember { mutableStateOf(List<HeroDraft?>(5) { null }) }
    var isLoading by remember { mutableStateOf(true) }
    var isAllyTurn by remember { mutableStateOf(true) }
    var selectedRole by remember { mutableStateOf("All") }

    val roles = listOf("All", "Assassin", "Fighter", "Mage", "Marksman", "Tank", "Support")
    val filteredHeroes = if (selectedRole == "All") allHeroes else allHeroes.filter { it.role.contains(selectedRole) }

    val winRates: Pair<Float, Float> = remember(allies, enemies, allHeroes) {
        calculateWinRate(allies, enemies, allHeroes)
    }

    val suggestions = remember(allies, enemies, allHeroes) {
        if (allHeroes.isNotEmpty()) calculateSuggestion(allies, enemies, allHeroes) else emptyList()
    }

    LaunchedEffect(Unit) {
        repository.fetchHeroes().onSuccess { allHeroes = it; isLoading = false }
    }

    Column(modifier = modifier.fillMaxSize().background(Color(0xFF121212))) {
        if (isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        } else {
            // 1. HEADER: SLOTS & WIN PROBABILITY
            Row(Modifier.fillMaxWidth().padding(8.dp), Arrangement.SpaceBetween) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    allies.forEachIndexed { i, h -> DraftSlot(h, true, "P${i+1}") { allies = allies.toMutableList().apply { this[i] = null } } }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(110.dp)) {
                    Text("WIN PROBABILITY", color = Color.Gray, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Row(Modifier.fillMaxWidth().height(8.dp).clip(CircleShape).background(Color.DarkGray)) {
                        Box(Modifier.fillMaxHeight().weight(winRates.first).background(Color(0xFF1E88E5)))
                        Box(Modifier.fillMaxHeight().weight(winRates.second).background(Color(0xFFE53935)))
                    }
                    Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                        Text("${winRates.first.toInt()}%", color = Color(0xFF1E88E5), fontSize = 10.sp)
                        Text("${winRates.second.toInt()}%", color = Color(0xFFE53935), fontSize = 10.sp)
                    }
                    Text(if (isAllyTurn) "BLUE TURN" else "RED TURN", color = if (isAllyTurn) Color(0xFF1E88E5) else Color(0xFFE53935), fontSize = 11.sp, fontWeight = FontWeight.Black)
                    Button(onClick = { allies = List(5) { null }; enemies = List(5) { null }; isAllyTurn = true }, Modifier.height(26.dp), contentPadding = PaddingValues(horizontal = 8.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
                        Text("Reset", fontSize = 8.sp, color = Color.White)
                    }
                }

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    enemies.forEachIndexed { i, h -> DraftSlot(h, false, "E${i+1}") { enemies = enemies.toMutableList().apply { this[i] = null } } }
                }
            }

            // 2. ROLE FILTER
            LazyRow(Modifier.fillMaxWidth().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(roles) { role ->
                    FilterChip(selected = selectedRole == role, onClick = { selectedRole = role }, label = { Text(role, fontSize = 10.sp) }, colors = FilterChipDefaults.filterChipColors(selectedContainerColor = Color(0xFFFFD700)))
                }
            }

            // 3. SUGGESTIONS
            if (suggestions.isNotEmpty()) {
                LazyRow(Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(suggestions.take(5)) { res ->
                        val hero = allHeroes.find { it.id == res.heroId }
                        hero?.let { SuggestionChip(it, res.score) }
                    }
                }
            }

            // 4. HERO GRID
            LazyVerticalGrid(columns = GridCells.Fixed(4), modifier = Modifier.weight(1f).padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(filteredHeroes) { hero ->
                    val isPicked = (allies + enemies).contains(hero)
                    Box(Modifier.alpha(if (isPicked) 0.3f else 1f)) {
                        HeroPickItem(hero) {
                            if (!isPicked) {
                                if (isAllyTurn) {
                                    val idx = allies.indexOf(null)
                                    if (idx != -1) { allies = allies.toMutableList().apply { this[idx] = hero }; isAllyTurn = false }
                                } else {
                                    val idx = enemies.indexOf(null)
                                    if (idx != -1) { enemies = enemies.toMutableList().apply { this[idx] = hero }; isAllyTurn = true }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DraftSlot(hero: HeroDraft?, isAlly: Boolean, label: String, onRemove: () -> Unit) {
    val teamColor = if (isAlly) Color(0xFF1E88E5) else Color(0xFFE53935)

    Row(
        modifier = Modifier
            .size(110.dp, 40.dp)
            .clip(RoundedCornerShape(4.dp))
            // Gunakan background di sini
            .background(if (hero == null) Color.Black.copy(0.4f) else teamColor.copy(0.2f))
            .border(1.dp, teamColor.copy(0.5f), RoundedCornerShape(4.dp))
            // Clickable ditaruh paling akhir biar area kliknya pas
            .clickable(enabled = hero != null) { onRemove() }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hero != null) {
            AsyncImage(
                model = hero.icons.round,
                contentDescription = "Hero Icon",
                modifier = Modifier.size(30.dp).clip(CircleShape)
            )
            Text(
                text = hero.name,
                color = Color.White,
                fontSize = 9.sp,
                modifier = Modifier.padding(start = 4.dp),
                maxLines = 1
            )
        } else {
            Text(
                text = label,
                color = teamColor.copy(0.5f),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun SuggestionChip(hero: HeroDraft, score: Float) {
    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)), border = BorderStroke(1.dp, Color.DarkGray)) {
        Row(Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(hero.icons.round, null, Modifier.size(24.dp).clip(CircleShape))
            Text(hero.name, color = Color.White, fontSize = 9.sp, modifier = Modifier.padding(horizontal = 4.dp))
            Text("+${score.toInt()}", color = Color(0xFF4CAF50), fontSize = 8.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun HeroPickItem(hero: HeroDraft, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { onClick() }) {
        AsyncImage(hero.icons.round, null, Modifier.size(50.dp).clip(CircleShape).border(1.dp, Color.DarkGray, CircleShape), contentScale = ContentScale.Crop)
        Text(hero.name, color = Color.White, fontSize = 9.sp, textAlign = TextAlign.Center, maxLines = 1)
    }
}
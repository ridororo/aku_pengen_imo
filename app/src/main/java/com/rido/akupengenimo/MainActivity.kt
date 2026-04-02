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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeroScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HeroScreen(modifier: Modifier = Modifier) {
    val heroes = getListHeroes()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Mobile Legends Heroes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = MaterialTheme.colorScheme.primary
        )
        
        LazyColumn {
            items(heroes) { hero ->
                HeroItem(hero = hero)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero) {
    var showDetails by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = hero.photo),
                    contentDescription = hero.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = hero.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = hero.description,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { showDetails = !showDetails },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = if (showDetails) "Hide Skills" else "Detail Skills")
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                IconButton(
                    onClick = { isFavorite = !isFavorite }
                ) {
                    Text(
                        text = if (isFavorite) "❤️" else "🤍",
                        fontSize = 24.sp
                    )
                }
            }

            AnimatedVisibility(visible = showDetails) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Hero Skills:",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
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
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = skill.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = skill.description,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

private fun getListHeroes(): List<Hero> {
    val lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore."
    
    return listOf(
        Hero(
            "Tigreal", "Tank - Crowd Control", R.drawable.tigreal,
            listOf(
                Skill("Skill 1: Attack Wave", lorem),
                Skill("Skill 2: Sacred Hammer", lorem),
                Skill("Ultimate: Implosion", lorem)
            )
        ),
        Hero(
            "Miya", "Marksman - Attack Speed", R.drawable.miya,
            listOf(
                Skill("Skill 1: Moon Arrow", lorem),
                Skill("Skill 2: Arrow of Eclipse", lorem),
                Skill("Ultimate: Hidden Moonlight", lorem)
            )
        ),
        Hero(
            "Balmond", "Fighter - True Damage", R.drawable.balmond,
            listOf(
                Skill("Skill 1: Soul Lock", lorem),
                Skill("Skill 2: Cyclone Sweep", lorem),
                Skill("Ultimate: Lethal Counter", lorem)
            )
        ),
        Hero(
            "Layla", "Marksman - Long Range", R.drawable.layla,
            listOf(
                Skill("Skill 1: Malefic Bomb", lorem),
                Skill("Skill 2: Void Projectile", lorem),
                Skill("Ultimate: Destruction Rush", lorem)
            )
        ),
        Hero(
            "Zilong", "Fighter/Assassin - Burst", R.drawable.zilong,
            listOf(
                Skill("Skill 1: Spear Flip", lorem),
                Skill("Skill 2: Spear Strike", lorem),
                Skill("Ultimate: Supreme Warrior", lorem)
            )
        )
    )
}

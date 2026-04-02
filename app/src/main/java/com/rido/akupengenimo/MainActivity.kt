package com.rido.akupengenimo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero) {
    val context = LocalContext.current
    
    // --- STATE MANAGEMENT (Modul 5) ---
    var isFavorite by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
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
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
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
                Spacer(modifier = Modifier.height(12.dp))
                
                Row {
                    Button(
                        onClick = {
                            Toast.makeText(context, "Melihat ${hero.name}", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.height(36.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Detail", fontSize = 12.sp)
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Button(
                        onClick = { isFavorite = !isFavorite },
                        modifier = Modifier.height(36.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isFavorite) Color(0xFFFF4081) else Color.Gray
                        )
                    ) {
                        Text(
                            text = if (isFavorite) "Favorited" else "Favorite",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

private fun getListHeroes(): List<Hero> {
    return listOf(
        Hero("Miya", "Marksman - Spesialis Attack Speed.", R.drawable.miya),
        Hero("Tigreal", "Tank - Spesialis Crowd Control.", R.drawable.tigreal),
        Hero("Balmond", "Fighter - Spesialis True Damage.", R.drawable.balmond),
        Hero("Layla", "Marksman - Jangkauan serangan jauh.", R.drawable.layla),
        Hero("Zilong", "Fighter/Assassin - Spesialis Push/Burst.", R.drawable.zilong)
    )
}

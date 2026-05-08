package com.rido.akupengenimo
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rido.akupengenimo.data.local.HeroDataProvider

@Composable
fun CounterDialog(hero: com.rido.akupengenimo.data.local.Hero, onDismiss: () -> Unit) {
    val info = HeroDataProvider.getCounterInfo(hero.id)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Strategy: ${hero.name}") },
        text = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                if (info != null) {
                    CounterIconsRow("Strong Against:", info.counters)
                    CounterIconsRow("Weak Against:", info.counteredBy)
                } else {
                    Text("Data counter nggak ketemu")
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("Close") } }
    )
}

@Composable
fun CounterIconsRow(title: String, ids: List<Int>) {
    Text(title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(ids) { id ->
            val iconUrl = HeroDataProvider.getIconById(id)
            AsyncImage(
                model = iconUrl,
                contentDescription = null,
                modifier = Modifier.size(45.dp).clip(CircleShape)
            )
        }
    }
}
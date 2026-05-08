package com.rido.akupengenimo

import com.rido.akupengenimo.data.remote.HeroDraft

// Data class untuk hasil perhitungan skor per hero
data class DraftResult(
    val heroId: Int,
    var score: Float,
    val pros: MutableList<String> = mutableListOf(),
    val cons: MutableList<String> = mutableListOf()
)

// Fungsi hitung probabilitas kemenangan tim
fun calculateWinRate(
    allies: List<HeroDraft?>,
    enemies: List<HeroDraft?>,
    allHeroes: List<HeroDraft>
): Pair<Float, Float> {
    val pickedAllies = allies.filterNotNull()
    val pickedEnemies = enemies.filterNotNull()

    if (pickedAllies.isEmpty() && pickedEnemies.isEmpty()) return Pair(50f, 50f)

    var allyPower = 0f
    var enemyPower = 0f

    pickedAllies.forEach { ally ->
        pickedEnemies.forEach { enemy ->
            if (ally.counteredBy.contains(enemy.id)) allyPower -= 1.0f
            if (ally.counters.contains(enemy.id)) allyPower += 1.0f
        }
    }

    pickedEnemies.forEach { enemy ->
        pickedAllies.forEach { ally ->
            if (enemy.counteredBy.contains(ally.id)) enemyPower -= 1.0f
            if (enemy.counters.contains(ally.id)) enemyPower += 1.0f
        }
    }

    val diff = allyPower - enemyPower
    val allyWinRate = (50f + (diff * 5f)).coerceIn(10f, 90f)
    return Pair(allyWinRate, 100f - allyWinRate)
}

// Fungsi hitung rekomendasi hero per individu
fun calculateSuggestion(
    allies: List<HeroDraft?>,
    enemies: List<HeroDraft?>,
    allHeroes: List<HeroDraft>
): List<DraftResult> {
    val results = mutableListOf<DraftResult>()

    fun addRelationship(heroId: Int, score: Float, reason: String) {
        val existing = results.find { it.heroId == heroId }
        if (existing != null) {
            existing.score += score
            if (score > 0) existing.pros.add(reason) else existing.cons.add(reason)
        } else {
            results.add(DraftResult(heroId, score,
                pros = if (score > 0) mutableListOf(reason) else mutableListOf(),
                cons = if (score < 0) mutableListOf(reason) else mutableListOf()
            ))
        }
    }

    enemies.filterNotNull().forEach { enemy ->
        enemy.counters.forEach { id -> addRelationship(id, -1f, "Countered by ${enemy.name}") }
        enemy.counteredBy.forEach { id -> addRelationship(id, 1f, "Counters ${enemy.name}") }
    }

    allies.filterNotNull().forEach { ally ->
        ally.synergy.forEach { id -> addRelationship(id, 0.1f, "Synergy with ${ally.name}") }
    }

    val pickedIds = (allies + enemies).filterNotNull().map { it.id }
    return results.filter { !pickedIds.contains(it.heroId) }.sortedByDescending { it.score }
}
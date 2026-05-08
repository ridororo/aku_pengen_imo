package com.rido.akupengenimo.data.remote

data class HeroDraft(
    val id: Int,
    val name: String,
    val role: List<String>,
    val lane: List<String>,
    val icons: DraftIcons,
    val counters: List<Int>,
    val counteredBy: List<Int>,
    val synergy: List<Int>,
    val antiSynergy: List<Int>
)

data class DraftIcons(
    val round: String,
    val rectangle: String
)

data class DraftResult(
    val heroId: Int,
    var score: Float,
    val pros: MutableList<String> = mutableListOf(),
    val cons: MutableList<String> = mutableListOf()
)
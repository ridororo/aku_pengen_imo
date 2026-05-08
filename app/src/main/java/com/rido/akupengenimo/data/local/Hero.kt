package com.rido.akupengenimo.data.local

data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val photoUrl: String,
    val skills: List<Skill> = emptyList()
)

data class Skill(
    val title: String,
    val description: String
)


data class Item(
    val name: String,
    val category: String,
    val photoUrl: String,
    val description: String
)
data class HeroCounter(
    val id: Int,
    val counters: List<Int>,
    val counteredBy: List<Int>,
    val synergy: List<Int>,
    val antiSynergy: List<Int>
)
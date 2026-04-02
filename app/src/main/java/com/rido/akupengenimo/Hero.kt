package com.rido.akupengenimo

data class Hero(
    val name: String,
    val description: String,
    val photo: Int,
    val skills: List<Skill> = emptyList()
)

data class Skill(
    val title: String,
    val description: String
)
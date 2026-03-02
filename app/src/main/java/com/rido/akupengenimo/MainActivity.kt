package com.rido.akupengenimo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHero: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengenalkan RecyclerView dari XML
        rvHero = findViewById(R.id.rv_hero)
        rvHero.setHasFixedSize(true)

        // Ambil data hero
        list.addAll(getListHeroes())

        // Tampilkan datanya
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = arrayOf("Miya", "Tigreal", "Balmond")
        val dataDescription = arrayOf(
            "Marksman - Spesialis Attack Speed.",
            "Tank - Spesialis Crowd Control.",
            "Fighter - Spesialis True Damage."
        )
        // Pastikan nama file di drawable adalah miya, tigreal, balmond
        val dataPhoto = arrayOf(
            R.drawable.miya,
            R.drawable.tigreal,
            R.drawable.balmond
        )

        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHero.adapter = listHeroAdapter
    }
}
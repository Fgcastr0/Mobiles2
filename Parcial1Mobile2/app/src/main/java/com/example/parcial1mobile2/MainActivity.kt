package com.example.parcial1mobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterChampion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AdapterChampion(this)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoChampions())
        adapter.onItemClickListener = { champion ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nombre", champion.nombre)
            intent.putExtra("imagen", champion.imagen)
            intent.putExtra("tipo", champion.tipo.name)
            intent.putExtra("rol", champion.rol)
            intent.putExtra("clase", champion.clase)

            startActivity(intent)
        }

    }
    private fun getListadoChampions():  MutableList<Champion> {
        return mutableListOf(
            Champion(1,"Ahri", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ahri_0.jpg", TipoCampeon.MAGO, "MID", "Rango"),
            Champion(2,"Garen", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Garen_0.jpg", TipoCampeon.LUCHADOR, "TOP", "Mele"),
            Champion(3,"Jinx", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Jinx_0.jpg", TipoCampeon.TIRADOR, "ADC", "Rango"),
            Champion(4,"Thresh", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Thresh_0.jpg", TipoCampeon.SOPORTE, "Soporte", "Mele"),
            Champion(5,"Lee Sin", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/LeeSin_0.jpg", TipoCampeon.LUCHADOR, "JUNGLE", "Mele"),
            Champion(6,"Lux", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Lux_0.jpg", TipoCampeon.MAGO, "MID", "Rango"),
            Champion(7,"Caitlyn", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Caitlyn_0.jpg", TipoCampeon.TIRADOR, "ADC", "Rango"),
            Champion(8,"Leona", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Leona_0.jpg", TipoCampeon.TANQUE, "Soporte", "Mele"),
            Champion(9,"Zed", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Zed_0.jpg", TipoCampeon.ASESINO, "MID", "Mele"),
            Champion(10,"Sejuani", "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Sejuani_0.jpg", TipoCampeon.TANQUE, "JUNGLE", "Mele")
        )
    }
}

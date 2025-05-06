package com.example.parcial1mobile2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nombre = intent.getStringExtra("nombre")
        val tipo = intent.getStringExtra("tipo")
        val rol = intent.getStringExtra("rol")
        val clase = intent.getStringExtra("clase")
        val imagenUrl = intent.getStringExtra("imagen")
        val imagenTipoId = intent.getIntExtra("imagenTipo", -1)

        val imageViewImagen = findViewById<ImageView>(R.id.imageViewImagen)
        val imageViewTipo = findViewById<ImageView>(R.id.imageViewType)
        val textViewNombre = findViewById<TextView>(R.id.textViewName)
        val textViewTipo = findViewById<TextView>(R.id.textViewTipo)
        val textViewRol = findViewById<TextView>(R.id.textViewRol)
        val textViewClase = findViewById<TextView>(R.id.textViewClase)

        textViewNombre.text = nombre
        textViewTipo.text = "Tipo: $tipo"
        textViewRol.text = "Rol: $rol"
        textViewClase.text = "Clase: $clase"

        // Imagen principal desde URL
        if (!imagenUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(imagenUrl)
                .into(imageViewImagen)
        }

        // Imagen del tipo (drawable local)
        if (imagenTipoId != -1) {
            imageViewTipo.setImageResource(imagenTipoId)
        }
    }
}

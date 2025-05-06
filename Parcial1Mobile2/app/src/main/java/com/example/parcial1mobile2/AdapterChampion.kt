package com.example.parcial1mobile2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterChampion(val context: Context) : ListAdapter<Champion, AdapterChampion.ViewHolder>(
    DiffCallBack
) {

    lateinit var onItemClickListener: (Champion) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val tipo: TextView = view.findViewById(R.id.textViewTipo)
        private val nombre: TextView = view.findViewById(R.id.textViewName)
        private val clase: TextView = view.findViewById(R.id.textViewClase)
        private val rol: TextView = view.findViewById(R.id.textViewRol)
        private val imagenTipo: ImageView = view.findViewById(R.id.imageViewType)
        private val imagenChampion: ImageView = view.findViewById(R.id.imageViewImage)

        fun bind (champion: Champion) {
            tipo.text = "Tipo: " + champion.tipo
            nombre.text = champion.nombre
            clase.text = "Clase: " + champion.clase
            rol.text = "Rol: " + champion.rol

            val image = when (champion.tipo) {
                TipoCampeon.TANQUE -> R.drawable.tanque
                TipoCampeon.SOPORTE -> R.drawable.soporte
                TipoCampeon.MAGO -> R.drawable.mago
                TipoCampeon.ASESINO -> R.drawable.asesino
                TipoCampeon.LUCHADOR -> R.drawable.luchador
                TipoCampeon.TIRADOR -> R.drawable.tirador
            }

            imagenTipo.setImageResource(image)

            Glide.with(context)
                .load(champion.imagen)
                .into(imagenChampion)

            view.setOnClickListener {
                onItemClickListener(champion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val champion = getItem(position)
        holder.bind(champion)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion): Boolean {
            return oldItem == newItem
        }
    }
}
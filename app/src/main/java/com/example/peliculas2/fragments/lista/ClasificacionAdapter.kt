package com.example.peliculas2.fragments.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.databinding.ActivityMainBinding.inflate
import com.example.peliculas2.databinding.ListaClasificacionBinding

class ClasificacionAdapter :
    RecyclerView.Adapter<ClasificacionAdapter.ClasificacionHolder>() {
    var listadoClasificacion : List<ClasificacionEntity> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ClasificacionHolder {
        val binding =
            ListaClasificacionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(holder: ClasificacionHolder, position: Int) : Unit =
        holder.bind(listadoClasificacion[position])

    override fun getItemCount(): Int = listadoClasificacion.size
    fun setData(clasificacion: List<ClasificacionEntity>) {
        this.listadoClasificacion = clasificacion
        notifyDataSetChanged()
    }
    inner class ClasificacionHolder(val binding: ListaClasificacionBinding)
        :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clasificacion: ClasificacionEntity) {
            with(binding) {
                TvIdClasificacion.text = clasificacion.idClasificacion.toString()
                TvNombreClasificacion.text = clasificacion.nombre
                TvAbreviacion.text = clasificacion.abreviacion

                ClFilaC.setOnClickListener {
                    val action =
                        ListaCFragmentDirections.listaCActualizar(clasificacion)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}



package com.example.peliculas2.fragments.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.bd.entidades.IdiomaEntity
import com.example.peliculas2.databinding.ListaIdiomaBinding

class IdiomaAdapter  :
    RecyclerView.Adapter<IdiomaAdapter.IdiomaHolder>() {
    private var listadoIdioma = emptyList<IdiomaEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): IdiomaHolder {
        val binding =

            ListaIdiomaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
        return IdiomaHolder(binding)
    }
    override fun onBindViewHolder(holder: IdiomaHolder,
                                  position: Int) {
        holder.bind(
            listadoIdioma[position]
        )
    }
    override fun getItemCount(): Int = listadoIdioma.size
    fun setData(users: List<IdiomaEntity>) {
        this.listadoIdioma = users
        notifyDataSetChanged()
    }
    inner class IdiomaHolder(val binding: ListaIdiomaBinding)
        :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(idioma: IdiomaEntity) {
            with(binding) {
                TvIdIdioma.text = idioma.idIdioma.toString()
                TvNombreIdioma.text = idioma.nombre

                ClFilaI.setOnClickListener {
                    val action =
                        ListaIFragmentDirections.listaIActualizar(idioma)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}

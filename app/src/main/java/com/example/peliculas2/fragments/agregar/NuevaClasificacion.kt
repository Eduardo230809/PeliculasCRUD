package com.example.peliculas2.fragments.agregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.peliculas2.R
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.bd.viewmodel.ClasificacionViewModel
import com.example.peliculas2.databinding.FragmentNuevaClasificacionBinding

class NuevaClasificacion : Fragment() {
    lateinit var fBinding: FragmentNuevaClasificacionBinding
    private lateinit var viewModel: ClasificacionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        fBinding = FragmentNuevaClasificacionBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ClasificacionViewModel::class.java)
        fBinding.BtnGuardar.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val nombre = fBinding.TxtNombreClasificacion.text.toString()
        val abreviacion = fBinding.TxtAbreviacion.text.toString()

            //Crear objeto
            val clasificacion = ClasificacionEntity(0, nombre, abreviacion, true)
            //Agregar nuevo usuario
            viewModel.agregarClasificacion(clasificacion)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ir_listaC)
        }

    }

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
import com.example.peliculas2.bd.entidades.IdiomaEntity
import com.example.peliculas2.bd.viewmodel.idiomaViewModel
import com.example.peliculas2.databinding.FragmentNuevoIdiomaBinding

class NuevoIdioma : Fragment(){
    lateinit var fBinding: FragmentNuevoIdiomaBinding
    private lateinit var viewModel: idiomaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        fBinding =
            FragmentNuevoIdiomaBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(idiomaViewModel::class.java)
        fBinding.BtnGuardar.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val nombre = fBinding.TxtNombreIdioma.text.toString()

            //Crear objeto
            val idioma = IdiomaEntity(0, nombre, activo = true)
            //Agregar nuevo usuario
            viewModel.agregarIdioma(idioma)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.irListaI)
        }



    }

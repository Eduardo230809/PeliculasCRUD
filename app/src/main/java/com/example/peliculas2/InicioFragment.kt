package com.example.peliculas2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.peliculas2.databinding.FragmentInicioBinding


class InicioFragment : Fragment() {

    private lateinit var binding : FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioBinding.inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews()  {
            binding.btnIdioma.setOnClickListener {

                it.findNavController().navigate(com.example.peliculas2.R.id.irA_listaIFragment)
            }
            binding.btnClasificacion.setOnClickListener {
                it.findNavController().navigate(com.example.peliculas2.R.id.irA_listaCFragment)
            }

    }


}
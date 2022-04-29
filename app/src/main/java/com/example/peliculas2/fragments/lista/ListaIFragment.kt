package com.example.peliculas2.fragments.lista

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculas2.R
import com.example.peliculas2.bd.viewmodel.idiomaViewModel
import com.example.peliculas2.databinding.FragmentListaIBinding

class ListaIFragment : Fragment() {
    lateinit var fBinding: FragmentListaIBinding
    private lateinit var viewModel : idiomaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentListaIBinding.inflate(layoutInflater)
        val adapter = IdiomaAdapter()
        val recycleView = fBinding.RcvListaIdioma
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext())
        viewModel =
            ViewModelProvider(this).get(idiomaViewModel::class.java)
        viewModel.lista.observe(viewLifecycleOwner, Observer
        {idioma->
            adapter.setData(idioma)
        })
        //Agregar el menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }
    private fun setupViews() {
        with(fBinding) {
            BtnAgregarIdioma.setOnClickListener {

                it.findNavController().navigate(R.id.nuevo_Idioma)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarTodo()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarTodo() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarTodo()
            Toast.makeText(
                requireContext(),
                "Registros eliminados satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando todos los registro")
        alerta.setMessage("¿Esta seguro de eliminar los registros?")
        alerta.create().show()
    }
}
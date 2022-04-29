package com.example.peliculas2.fragments.actualizar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.peliculas2.R
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.bd.entidades.IdiomaEntity
import com.example.peliculas2.bd.viewmodel.ClasificacionViewModel
import com.example.peliculas2.bd.viewmodel.idiomaViewModel
import com.example.peliculas2.databinding.FragmentActualizarCBinding
import com.example.peliculas2.databinding.FragmentActualizarIBinding

class ActualizarIdioma : Fragment()  {
    lateinit var fBinding: FragmentActualizarIBinding
    private val args by navArgs<ActualizarIdiomaArgs>()
    private lateinit var viewModel: idiomaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentActualizarIBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(idiomaViewModel::class.java)
        with(fBinding) {

            TxtNombreIdioma.setText(args.currentIdioma.nombre)

            BtnActualizaridioma.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val nombre = fBinding.TxtNombreIdioma.text.toString()
        //Crear el objeto
        val clasificacion =
            IdiomaEntity(args.currentIdioma.idIdioma,
                nombre, activo = true)
        //Actualizar
        viewModel.actualizarIdioma(clasificacion)
        Toast.makeText(requireContext(), "Registro actualizado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.actualizar_ListaClasificacion)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarIdioma()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarIdioma() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarIdioma(args.currentIdioma)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_ListaIdioma)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando${args.currentIdioma.nombre}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentIdioma.nombre}?")
        alerta.create().show()
    }
}
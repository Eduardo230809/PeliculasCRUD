package com.example.peliculas2.fragments.actualizar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.peliculas2.ActualizarCFragment
import com.example.peliculas2.R
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.bd.viewmodel.ClasificacionViewModel
import com.example.peliculas2.databinding.FragmentActualizarCBinding

class ActualizarClasificacion : Fragment()  {
    lateinit var fBinding: FragmentActualizarCBinding
    private val args by navArgs<ActualizarClasificacionArgs>()
    private lateinit var viewModel: ClasificacionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentActualizarCBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ClasificacionViewModel::class.java)
        with(fBinding) {

            TxtNombreClasificacion.setText(args.currentClasificacion.nombre)
            TxtAbreviacion.setText(args.currentClasificacion.abreviacion)

            BtnActualizarClasificacion.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val nombre = fBinding.TxtNombreClasificacion.text.toString()
        val abreviacion = fBinding.TxtAbreviacion.text.toString()
        //Crear el objeto
        val clasificacion =
            ClasificacionEntity(args.currentClasificacion.idClasificacion,
                nombre, abreviacion, activo = true)
        //Actualizar
        viewModel.actualizarClasificacion(clasificacion)
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
            eliminarClasificacion()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarClasificacion() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarClasificacion(args.currentClasificacion)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_ListaClasificacion)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando${args.currentClasificacion.nombre}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentClasificacion.nombre}?")
        alerta.create().show()
    }
}
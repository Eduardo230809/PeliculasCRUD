package com.example.peliculas2.bd.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.peliculas2.bd.dao.MainBaseDatos
import com.example.peliculas2.bd.entidades.IdiomaEntity
import com.example.peliculas2.bd.repository.IdiomaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class idiomaViewModel (application:
                       Application
): AndroidViewModel(application) {
    val lista : LiveData<List<IdiomaEntity>>
    private val repository: IdiomaRepository
    init {
        val idiomaDao =
            MainBaseDatos.getDataBase(application).idiomaDao()
        repository = IdiomaRepository(idiomaDao)
        lista = repository.listado
    }
    fun agregarIdioma(idioma: IdiomaEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addIdioma(idioma)
        }
    }
    fun actualizarIdioma(idioma: IdiomaEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateIdioma(idioma)
        }
    }
    fun eliminarIdioma(idioma: IdiomaEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteIdioma(idioma)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}
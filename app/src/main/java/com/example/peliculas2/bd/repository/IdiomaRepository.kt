package com.example.peliculas2.bd.repository

import androidx.lifecycle.LiveData
import com.example.peliculas2.bd.dao.IdiomaDao
import com.example.peliculas2.bd.entidades.IdiomaEntity

class IdiomaRepository(private val dao: IdiomaDao) {
    val listado: LiveData<List<IdiomaEntity>> =
        dao.getAllRealData()

    suspend fun addIdioma(idioma: IdiomaEntity) {
        dao.insert(idioma)
    }

    suspend fun updateIdioma(idioma: IdiomaEntity) {
        dao.update(idioma)
    }

    suspend fun deleteIdioma(idioma: IdiomaEntity) {
        dao.delete(idioma)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}
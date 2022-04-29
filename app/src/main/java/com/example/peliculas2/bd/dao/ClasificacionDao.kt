package com.example.peliculas2.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peliculas2.bd.entidades.ClasificacionEntity
@Dao
interface ClasificacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clasificacion: ClasificacionEntity)

    @Query("SELECT * FROM TblClasificacion")
    suspend fun getAll(): List<ClasificacionEntity>

    @Query("SELECT * FROM TblClasificacion")
    fun getAllRealData(): LiveData<List<ClasificacionEntity>>

    @Update
    suspend fun update(clasificacion: ClasificacionEntity)

    @Delete
    suspend fun delete(clasificacion: ClasificacionEntity)

    @Query("Delete from TblClasificacion")
    suspend fun deleteAll()
}
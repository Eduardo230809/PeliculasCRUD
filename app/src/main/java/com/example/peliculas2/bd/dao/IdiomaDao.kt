package com.example.peliculas2.bd.dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peliculas2.bd.entidades.IdiomaEntity
@Dao
interface IdiomaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(idioma: IdiomaEntity)

    @Query("SELECT * FROM TblIdioma")
    suspend fun getAll(): List<IdiomaEntity>

    @Query("SELECT * FROM TblIdioma")
    fun getAllRealData(): LiveData<List<IdiomaEntity>>

    @Update
    suspend fun update(idioma: IdiomaEntity)

    @Delete
    suspend fun delete(idioma: IdiomaEntity)

    @Query("Delete from TblIdioma")
    suspend fun deleteAll()

}
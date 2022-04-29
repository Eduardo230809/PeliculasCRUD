package com.example.peliculas2.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.peliculas2.bd.entidades.ClasificacionEntity
import com.example.peliculas2.bd.entidades.IdiomaEntity

interface MainDataBaseProvider {
    fun clasificacionDao(): ClasificacionDao
    fun idiomaDao(): IdiomaDao
}
@Database(
    entities = [ClasificacionEntity::class, IdiomaEntity::class],
    version = 2
)
abstract class MainBaseDatos : RoomDatabase(),
    MainDataBaseProvider {
    abstract override fun clasificacionDao(): ClasificacionDao
    abstract override fun idiomaDao(): IdiomaDao
    companion object {
        @Volatile
        private var INSTANCE: MainBaseDatos? = null
        fun getDataBase(context: Context): MainBaseDatos {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainBaseDatos::class.java,
                        "main_db"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
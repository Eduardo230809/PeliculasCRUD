package com.example.peliculas2.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "TblIdioma")
class IdiomaEntity (
    @PrimaryKey(autoGenerate = true)
    val idIdioma: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "activo")
    val activo: Boolean = true
): Parcelable
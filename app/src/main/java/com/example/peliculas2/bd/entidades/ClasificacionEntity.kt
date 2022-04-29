package com.example.peliculas2.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "TblClasificacion")
class ClasificacionEntity (
    @PrimaryKey(autoGenerate = true)
    val idClasificacion: Int = 0,
    @ColumnInfo(name = "abreviacion")
    val abreviacion: String,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "activo")
    val activo: Boolean = true
): Parcelable
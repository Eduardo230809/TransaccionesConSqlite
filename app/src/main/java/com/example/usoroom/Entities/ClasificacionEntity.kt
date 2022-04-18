package com.example.usoroom.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="TblClasificacion")
class ClasificacionEntity (
    @ColumnInfo(name = "abreviacion")
    val abreviacion: String,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "activo")
    val activo: Boolean = true,
    @PrimaryKey(autoGenerate = true)
    val idClasificacion:Int=0
    )
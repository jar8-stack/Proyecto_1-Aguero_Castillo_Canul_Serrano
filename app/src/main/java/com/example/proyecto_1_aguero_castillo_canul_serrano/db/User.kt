package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import android.content.res.Configuration
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class User(
    @PrimaryKey @ColumnInfo(name="id_usuario") val id_usuario: Int,
    @ColumnInfo(name = "nombre_usuario") var nombre_usuario: String,
    @ColumnInfo(name = "score_usuario") var score_usuario: Int,
    @ColumnInfo(name = "id_configuration") val id_configuration: Int
){
    override fun toString(): String {
        return "${id_usuario}-${nombre_usuario}"
    }
}
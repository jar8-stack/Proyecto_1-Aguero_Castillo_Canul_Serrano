package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "configuration_themes")
data class configuration_themes (
    @ColumnInfo(name = "id_configuration") val id_configuration: Int,
    @ColumnInfo(name = "id_theme") val id_theme: Int
)
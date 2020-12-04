package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configurations")
data class configurations(
    @PrimaryKey @ColumnInfo(name = "id_configuration") val id_configuration: Int,
    @ColumnInfo(name = "number_questions") var number_questions: Int,
    @ColumnInfo(name = "dificulty") var dificulty: String,
    @ColumnInfo(name = "number_tracks") var number_tracks: Int,
    @ColumnInfo(name = "tracks_enabled") var tracks_enabled: Boolean
)
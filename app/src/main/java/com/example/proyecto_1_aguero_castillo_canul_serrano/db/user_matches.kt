package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_matches")
data class User_matches(
    @PrimaryKey @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "id_usuario") val id_usuario:Int,
    @ColumnInfo(name = "current_question") var current_question:Int,
    @ColumnInfo(name = "answered_question") var answered_question:Int,
    @ColumnInfo(name = "correct_questions") var correct_questions:Float,
    @ColumnInfo(name = "points") var points:Float,
    @ColumnInfo(name = "use_hint") var use_hint:Boolean
)

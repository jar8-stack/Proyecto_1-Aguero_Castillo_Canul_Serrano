package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "question_answers")
data class question_answers(
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "text") var text: String,
)
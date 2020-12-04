package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class questions(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    //Foreing key
    @ColumnInfo(name = "text") var text: String
)
package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import android.accounts.AuthenticatorDescription
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class Theme(
    @PrimaryKey @ColumnInfo(name="id") val id: Int,
    @ColumnInfo(name="description") var description: String
)
package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM usuario")
    fun getUser(): List<User>
}
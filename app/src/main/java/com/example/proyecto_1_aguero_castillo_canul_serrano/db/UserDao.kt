package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT id_usuario, nombre_usuario, score_usuario, id_configuration FROM usuario")
    fun getUser(): List<User>
}
package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM usuario")
    fun getUsers(): List<User>

    @Query("SELECT * FROM usuario WHERE id_usuario = :idUser")
    fun getUser(idUser:Int):User

    @Query("INSERT INTO usuario(nombre_usuario, score_usuario, id_configuration) VALUES(:userName, :score, :id_config)")
    fun insertUser(userName:String,score:Int,id_config:Int)

    @Query("SELECT id_usuario from usuario order by id_usuario DESC limit 1")
    fun traerUltimoIdUsuarios() : Int

    @Insert
    fun insertUser(user: User)
}
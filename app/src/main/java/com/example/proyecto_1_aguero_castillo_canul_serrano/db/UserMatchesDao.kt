package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserMatchesDao {
    @Query("Insert into user_matches(id_usuario,current_question,answered_question,correct_questions,points,use_hint) values (:id_user,:current_question,:answered_questions,:correct_questions,:points,:use_hint)")
    fun insertMatch(id_user:Int,current_question:Int,answered_questions:Int,correct_questions:Float,points:Float,use_hint:Boolean)
}
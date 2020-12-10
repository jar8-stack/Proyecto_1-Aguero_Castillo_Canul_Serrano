package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.*

@Dao
interface ConfigurationDao {

    @Query("SELECT * FROM configurations")
    fun getThemes(): List<Configuration>

    @Update
    fun updateConfiguration(configuration: Configuration)

    @Update
    fun updateConfiguration(configuration: List<Configuration>)

    @Insert
    fun insertConfiguration(configuration: Configuration)

    @Query("INSERT INTO configurations(number_questions, dificulty, number_tracks,tracks_enabled) VALUES(:numberQuestion, :dificultyLevel, :numberTracks, :tracksEnabled)")
    fun insertConfiguration(numberQuestion:Int,dificultyLevel:String,numberTracks:Int,tracksEnabled:Boolean)

    @Query("SELECT id_configuration from configurations order by id_configuration DESC limit 1")
    fun traerUltimoIdConfiguraciones() : Int

    @Delete
    fun deleteConfiguration(configuration: Configuration)
}
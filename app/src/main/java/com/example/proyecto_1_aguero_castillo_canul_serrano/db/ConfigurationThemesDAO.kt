package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ConfigurationThemesDAO {

    @Query("INSERT INTO configuration_themes(id_configuration_theme,id_configuration,id_theme) VALUES(null,:idConfiguration,:idTheme)")
    fun insertConfigurationTheme(idConfiguration:Int,idTheme:Int)

}
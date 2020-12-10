package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.*

@Dao
interface ThemesDao {
    @Query("SELECT id, description FROM themes")
    fun getThemes(): List<Theme>

    @Query("SELECT* FROM THEMES WHERE id >= :lowId AND id <= :highId")
    fun getThemes(lowId: Int, highId: Int): List<Theme>

    @Query("SELECT * FROM themes WHERE id IN(:themeIds)")
    fun getThemes(themeIds: List<Int>): List<Theme>

    @Query("SELECT * FROM themes WHERE id= :themeId")
    fun getTheme(themeId: Int): Theme

    @Query("SELECT id FROM themes WHERE description LIKE :description LIMIT 1")
    fun getThemeId(description: String): Int

    /*
    @Query("SELECT id_usuario FROM usuario WHERE nombre_usuario= :user_name")
    fun getUsuario(user_name: String): Int
    */
    @Update
    fun updateTheme(theme: Theme)

    @Update
    fun updateThemes(themes: List<Theme>)

    @Insert
    fun insertTheme(theme: Theme)

    @Delete
    fun deleteTheme(theme: Theme)
}
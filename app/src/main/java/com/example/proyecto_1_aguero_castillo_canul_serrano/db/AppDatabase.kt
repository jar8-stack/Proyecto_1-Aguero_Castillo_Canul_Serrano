package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Theme::class, User::class, configuration_themes::class, configurations::class, question_answers::class, questions::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun themeDao(): ThemesDao
}
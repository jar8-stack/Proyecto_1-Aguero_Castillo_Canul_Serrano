package com.example.proyecto_1_aguero_castillo_canul_serrano.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Theme::class, User::class, configuration_themes::class, Configuration::class, question_answers::class, Questions::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun themeDao(): ThemesDao
    abstract fun userDao(): UserDao
    abstract fun configurationDao(): ConfigurationDao
    abstract fun ConfigurationThemesDAO(): ConfigurationThemesDAO
}
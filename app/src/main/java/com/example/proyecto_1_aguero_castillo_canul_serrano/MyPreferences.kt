package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.content.Context

class MyPreferences(context : Context) {
    val PREFERENCES_NAME = "SharedPreferencesGame"
    val PREFERENCES_CANTIDAD_PREGUNTAS = "SharedPreferencesCantidadPreguntas"
    val PREFERENCES_NIVEL_ESTABLECIDO = "SharedPreferencesNivelEstablecido"
    val PREFERENCES_CANTIDAD_PISTAS = "SharedPreferencesCantidadPistas"
    val PREFERENCES_PISTAS_ACTIVAS = "SharedPreferencesPistasActivas"

    val preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE)

    fun getCantidadPreguntas() : Int{
        return preferences.getInt(PREFERENCES_CANTIDAD_PREGUNTAS, 5)
    }

    fun setCantidadPreguntas(Cantidad : Int){
        val editor = preferences.edit()
        editor.putInt(PREFERENCES_CANTIDAD_PREGUNTAS, Cantidad)
        editor.apply()
    }

    fun getNivelEstablecido() : Int { // 0 = BAJA, 1 = MEDIA, 2 = ALTA
        return preferences.getInt(PREFERENCES_NIVEL_ESTABLECIDO, 1)
    }

    fun setNivelEstablecido(Nivel : Int){
        val editor = preferences.edit()
        editor.putInt(PREFERENCES_NIVEL_ESTABLECIDO, Nivel)
        editor.apply()
    }

    fun getCantidadPistas() : Int{
        return preferences.getInt(PREFERENCES_CANTIDAD_PISTAS, 3)
    }

    fun setCantidadPistas(Cantidad : Int){
        val editor = preferences.edit()
        editor.putInt(PREFERENCES_CANTIDAD_PISTAS, Cantidad)
        editor.apply()
    }

    fun getPistasActivas() : Boolean{
        return preferences.getBoolean(PREFERENCES_PISTAS_ACTIVAS, false)
    }

    fun setPistasActivas(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_PISTAS_ACTIVAS, Activo)
        editor.apply()
    }
}
package com.example.proyecto_1_aguero_castillo_canul_serrano

import androidx.lifecycle.ViewModel

class SettingsModel : ViewModel() {

    private var dificultad = 1 // 0 = BAJA, 1 = MEDIA, 2 = ALTA
    private var pistasActivadas = 0 // 0 = NO, 1 = SI
    private var numeroPistas = 3

    val obtenerDificultad: Int
        get() = dificultad

    fun nextQuestion() {
        //currentIndex = (currentIndex + 1) % questionBank.size
    }

    override fun onCleared() {
        super.onCleared()
        //Log.d()
    }
}
package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val model: GameModel
        get() {
            TODO()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSettings.setOnClickListener {
            val intent:Intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}
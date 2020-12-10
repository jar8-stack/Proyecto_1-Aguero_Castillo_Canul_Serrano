package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.proyecto_1_aguero_castillo_canul_serrano.Preferences.MyPreferences
import com.example.proyecto_1_aguero_castillo_canul_serrano.db.AppDatabase
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val misPreferencias = MyPreferences(this)

        nombreUsuario.text = misPreferencias.getNombreUsuario() + " - " + misPreferencias.getIdUsuario();

        btnCerrarSesion.setOnClickListener {
            misPreferencias.setLogeado(false)
            val intent:Intent = Intent(this, SelectPlayerActivity::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            val intent:Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnGame.setOnClickListener {
            val intent:Intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}

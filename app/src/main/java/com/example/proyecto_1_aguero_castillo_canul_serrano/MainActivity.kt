package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.proyecto_1_aguero_castillo_canul_serrano.db.AppDatabase
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Stetho.initializeWithDefaults(this)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "quizzapp.db"
        ).allowMainThreadQueries().addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)


                db.execSQL("INSERT INTO quizzapp.configurations(number_questions, dificulty, number_tracks, tracks_enabled) VALUES(5, 'Facil', 0, 0);")

                db.execSQL("INSERT INTO usuario(nombre_usuario, score_usuario, id_configuration) VALUES('usuario_prueba', 0, 1);")
                db.execSQL("INSERT INTO usuario(nombre_usuario, score_usuario, id_configuration) VALUES('usuario_prueba2_olo', 0, 1);")

            }}).build()

        val user= db.userDao().getUser()
        //Hola mundo




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
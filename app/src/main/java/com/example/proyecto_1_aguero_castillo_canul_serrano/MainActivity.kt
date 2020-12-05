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
            "quizapp_1.db"
        ).allowMainThreadQueries().addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                /*db.execSQL("INSERT INTO configurations(number_questions, dificulty, number_tracks, tracks_enabled) VALUES(5, 'Facil', 0, 0);")
                db.execSQL("INSERT INTO usuario(nombre_usuario, score_usuario, id_configuration) VALUES('usuario_prueba', 0, 1);")*/
                insertThemes(db)
                insertDefaultConfig(db)
                insertQuestionsWAnswers(db)

            }}).build()

        //db.userDao().insertUser("Stunbox",0,1) funcion para insertar usuario
        val themes= db.themeDao().getThemes()


        btnSettings.setOnClickListener {
            val intent:Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnGame.setOnClickListener {
            val intent:Intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
    fun insertThemes(db:SupportSQLiteDatabase){
        db.execSQL("INSERT INTO [themes](description) VALUES('Arte');")
        db.execSQL("INSERT INTO [themes](description) VALUES('Ciencia');")
        db.execSQL("INSERT INTO [themes](description) VALUES('Cine');")
        db.execSQL("INSERT INTO [themes](description) VALUES('Historia');")
        db.execSQL("INSERT INTO [themes](description) VALUES('Programacion');")
        db.execSQL("INSERT INTO [themes](description) VALUES('Cultura General');")
    }
    fun insertDefaultConfig(db: SupportSQLiteDatabase){
        db.execSQL("INSERT INTO configurations(number_questions, dificulty, number_tracks, tracks_enabled) VALUES(5, 'Facil', 0, 0);")
    }
    fun insertQuestionsWAnswers(db: SupportSQLiteDatabase){

    }
}
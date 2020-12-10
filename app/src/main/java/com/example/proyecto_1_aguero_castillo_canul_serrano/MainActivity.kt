package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.proyecto_1_aguero_castillo_canul_serrano.db.AppDatabase
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val dbValues:Database = Database()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Stetho.initializeWithDefaults(this)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            dbValues.getName()
        ).allowMainThreadQueries().build()

        //db.userDao().insertUser("Stunbox",0,1) funcion para insertar usuario
        val themes= db.themeDao().getThemes()


        btnSettings.setOnClickListener {
            val intent:Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        btnGame.setOnClickListener {


            val mAlertDialogJuego= AlertDialog.Builder(this@MainActivity)
            mAlertDialogJuego.setTitle("Returnar juego")
            mAlertDialogJuego.setMessage("¿Desea reanudar partida?")
            mAlertDialogJuego.setPositiveButton("Si") MainActivity@{ dialog, id ->
                //Reanudar partida guardada
                val intent:Intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }

            mAlertDialogJuego.setNegativeButton("No"){dialog, id ->
                //Partida nueva
                val intent:Intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }

            mAlertDialogJuego.show()
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
        //ARTE
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿Quien pinto la monalisa?');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿En que siglo nació Van Gogh?');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿En que siglo nacio Diego Velázquez?');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿En que museo esta la monalisa?');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿Qué nombre recibe el estilo arquitectónico de las construcciones árabes en la península?');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿En que año pinto Picasso el Guernica?');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿Quien hizo el mural de la capilla sixtina?');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿Uno de estos artistas es mexicano?');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿Quien pinto el nacimiento de venus?');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(1, '¿En que siglo se inició el renacimiento?');\n")

        //CIENCIA
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Cuál es el país más grande del mundo?');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Qué animal utilizó Ivan Pavlov en sus experimentos?');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Qué es el complejo de Edipo?');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Por qué es conocida la bióloga británica Jane Goodall?');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Quiénes crearon el número 0?');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿De donde viene la priedra pomex?');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, 'Elemento mas pesado de la tabla periodica');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿Por qué es famoso el cometa Halley?');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, 'El dinosaurio más pequeño que existió sobre la faz de la Tierra fue...');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(2, '¿De qué está compuesta la lluvia ácida?');")

        //CINE
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Tu falta de fe me resulta perturbadora');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Cancion que suena en los creditos del club de la pelea');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Director que dirigio la cinta la naranja mecanica');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Pelicula en la que aparece Bruce Willis y Jhon Travolta en el reparto');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Ultima pelicula de Cameron Boyce');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Actor que inetrpreta a batman en la trilogia de Nolan');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Pelicula en la que aparece keanu reeves en donde todo ocurre por un perro');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Primer anime en ganar un oscar');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Actor que aparece en el video musical de Stylo de gorillaz');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(3, 'Serie de hacker mas cercana a la realidad');")

        //HISTORIA
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Qué líder tribal luchó contra la ocupación romana de Gran Bretaña (Britania)?');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Con qué nombre se conoce el escándalo que obligó al presidente estadounidense Richard Nixon a dimitir?');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Qué esposas de Enrique VIII fueron decapitadas?');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Qué emperador romano legalizó el cristianismo y puso fin a la persecución de los cristianos?');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Cuántas personas murieron durante el Gran Incendio de Londres de 1666 según los registros?');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Qué hito informático de 1969 cambiaría radicalmente el curso de la historia de la humanidad?');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, 'Primer presidente de EEUU');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Por qué es significativo el Poema de Gilgamesh?');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿Cuál es el nombre de la famosa batalla donde Napoleón Bonaparte fue derrotado?s');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(4, '¿A través de qué río africano se alzó el antiguo Egipto?');")

        //PROGRAMACIÓN
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Lenguaje de programación favorito de los hackers');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Lenguaje de programación militar creado por las fuerzas armadas de los Estados Unidos');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'La siguiente es una metodologpia agil de desarrollo de software');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'IDE mas utilizada para desarrollo movil Android');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Es elsguiente es un bucle');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Ssistema operativo basado en UNIX utilizado mayormente para areas operativas del software');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Lenguaje de etiquetas utilizado para el desarrollo de paginas web');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Framework de desarrollo movil hibrido de nodeJS utilizado por facebook para su aplicación');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'El sigueinte es un lenguaje de programación utilizado para desarrollo nativo Android');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(5, 'Framework de desarrollo web de python');")

        //CULTURA GENERAL
        //1
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Cuales son los 5 tipos de sabores primarios?');")
        //2
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Cual es el lugar mas frio en la tierra?');")
        //3
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Quien escribio la odisea?');")
        //4
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Cual es el rio mas largo del mundo ¿?');")
        //5
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, 'Como se llama la actual reina del Reino Unidos');")
        //6
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿En qué continente esta Ecuador?');")
        //7
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Donde se originaron los juegos olimpicos?');")
        //8
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿Que tipo de animal es la ballena?');")
        //9
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿De que color es la bandera de México?');")
        //10
        db.execSQL("INSERT INTO questions(theme_id, text) VALUES(6, '¿En que año finalizo la segunda guerra mundial?');")


        //Respuestas de pregunta 1
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(1, 'Leonardo Da Vinci', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(1, 'Leonardo Di Caprio', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(1, 'Loreto De Avila', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(1, 'Miguel Angel', 0);")
        //Respuestas de pregunta 2
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(2, 'Siglo XIX', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(2, 'Siglo XX', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(2, 'Siglo XVII', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(2, 'Siglo XVIII', 0);")
        //Respuestas de pregunta 3
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(3, 'Siglo XVII', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(3, 'Siglo XVI', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(3, 'Siglo XVIII', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(3, 'Siglo XV', 0);")
        //Respuestas de pregunta 4
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(4, 'Louvre', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(4, 'Museo del prado', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(4, 'Galeria Uffizi', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(4, 'British Museum', 0);")
        //Respuestas de pregunta 5
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(5, 'Mozárabe', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(5, 'Arabesco', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(5, 'Nazarí', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(5, 'Arábigo', 0)")
        //Respuestas de pregunta 6
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(6, '1937', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(6, '1947', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(6, '1957', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(6, '1927', 0);")
        //Respuestas de pregunta 7
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(7, 'Miguel Angel', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(7, 'San Agustin', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(7, 'Frida Khalo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(7, 'Hugo Lopez Mateo', 0);")
        //Respuestas de pregunta 8
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(8, 'Frida Khalo', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(8, 'Leonardo Da Vinci', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(8, 'Miguel Angel', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(8, 'Augusto Compte', 0);")
        //Respuestas de pregunta 9
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(9, 'Botticelli', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(9, 'Santiago el noble', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(9, 'Tiziano', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(9, 'Oscar de la olla', 0);")
        //Respuestas de pregunta 10
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(10, 'Siglo XV', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(10, 'Siglo XIV', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(10, 'Siglo XIII', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(10, 'Siglo XXI', 0);")
        //Respuestas de pregunta 11
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(11, 'Rusia', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(11, 'Canadá', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(11, 'Estados Unidos', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(11, 'Mexico', 0);")
        //Respuestas de pregunta 12
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(12, 'Perros', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(12, 'Roedores', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(12, 'Gatos', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(12, 'Loros', 0);")
        //Respuestas de pregunta 13
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(13, 'Evidencia un sentimienyo romantico/sexual del niño hacia la madre, viendo al padre como rival', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(13, 'Evidencia de un sentimiento morboso de celos exagerados', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(13, 'Distorsión de la realidad', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(13, 'Pensamiento del paciente que hace que piense que se encuentre en un programa de televisión', 0);")
        //Respuestas de pregunta 14
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(14, 'Por su estudio sobre los primates de Tanzania', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(14, 'Por su estudio sobre los osos polares en el Artico', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(14, 'Por su estudio sobre los koalas en Australia', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(14, 'Por su estudio de los manatis en México', 0);")
        //Respuestas de pregunta 15
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(15, 'Los mayas', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(15, 'Los árabes', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(15, 'Los romanos', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(15, 'Los griegos', 0);")
        //Respuestas de pregunta 16
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(16, 'Del magma de los volcanes', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(16, 'Del fondo marino', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(16, 'De las minas', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(16, 'del espacio', 0);")
        //Respuestas de pregunta 17
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(17, 'Osmio', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(17, 'Iridio', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(17, 'Wolframio', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(17, 'Cobre', 0);")
        //Respuestas de pregunta 18
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(18, 'Por ser el primer cometa reconocido con orbita cíclica', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(18, 'Por ser el primer cometa descubierto por el hombre', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(18, 'Por casi destruir la tierra', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(18, 'Por su descubridor Galileo Galilei', 0);")
        //Respuestas de pregunta 19
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(19, 'El compsognathus', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(19, 'El tiranosaurio rex', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(19, 'El terodactilo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(19, 'El pisonosaurus', 0);")
        //Respuestas de pregunta 20
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(20, 'De ácido sulfúrico y acido nítrico', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(20, 'De ácido nítrico y acido clorhídrico', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(20, 'De ácido nítrico y úrico', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(20, 'De oxido y potasio', 0);")
        //Respuestas de pregunta 21
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(21, 'The Godfather', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(21, 'Star Wars', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(21, 'The Sting', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(21, 'El club de la pelea', 0);")
        //Respuestas de pregunta 22
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(22, 'Where is my mind?', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(22, 'The beatles lucy in the sky with diamonds', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(22, 'Mariposa de amor', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(22, 'Nirvana- come as you are', 0);")
        //Respuestas de pregunta 23
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(23, 'stanley kubrick', 1)")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(23, 'christian bale', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(23, 'Quentin tarantino', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(23, 'Woody Allen', 0);")
        //Respuestas de pregunta 24
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(24, 'Pulp fiction', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(24, 'La naranja mecanica', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(24, 'Amores perros', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(24, 'Nosotros los nobles', 0);")
        //Respuestas de pregunta 25
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(25, 'Descendientes 3', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(25, 'Descendientes 2', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(25, 'Runt', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(25, 'Descendientes 4', 0);")
        //Respuestas de pregunta 26
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(26, 'christian bale', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(26, 'Ben afleck', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(26, 'Robert pattinson', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(26, 'Adam west', 0);")
        //Respuestas de pregunta 27
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(27, 'Matrix', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(27, 'John Wick', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(27, 'Maxima velocidad', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(27, 'Constantine', 0);")
        //Respuestas de pregunta 28
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(28, 'El viaje de chihiro', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(28, 'Death note', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(28, 'Naruto', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(28, 'Dragon ball', 0);")
        //Respuestas de pregunta 29
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(29, 'bruce willis', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(29, 'johnny depp', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(29, 'will smith', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(29, 'keanu reeves', 0);")
        //Respuestas de pregunta 30
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(30, 'Mr robot', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(30, 'Ningún sistema es seguro', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(30, 'Code porsuite', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(30, 'Duro de matar', 0);")
        //Respuestas de pregunta 31
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(31, 'Boudica', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(31, 'Tácito', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(31, 'Ariovistus', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(31, 'Prasutagus', 0);")
        //Respuestas de pregunta 32
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(32, 'Watergate', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(32, 'Vietnam', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(32, 'Powergate', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(32, 'Nixon Process', 0);")
        //Respuestas de pregunta 33
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(33, 'Ana Bolena y Catherine Howard', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(33, 'Ana de Cléveris y Ana Bolena', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(33, 'Ana Bolena y Catalina de Aragón', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(33, 'Catalina Howard y Catalina Parr', 0);")
        //Respuestas de pregunta 34
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(34, 'Constantino', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(34, 'Nerón', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(34, 'Trajano', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(34, 'Adriano', 0);")
        //Respuestas de pregunta 35
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(35, '6', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(35, '60', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(35, '600', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(35, '6000', 0);")
        //Respuestas de pregunta 36
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(36, 'Internet', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(36, 'El primer ipod', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(36, 'El primer ordenador personal', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(36, 'El primer router de wifi', 0);")
        //Respuestas de pregunta 37
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(37, 'Abraham Lincoln', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(37, 'George Washington', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(37, 'Thomas Jefferson', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(37, 'Andrew Jackson', 0);")
        //Respuestas de pregunta 38
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(38, 'Es la primera obra epica que hacer referencia a la inmortalidad y la percepción huamana del alma', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(38, 'Sobre un gigante llamado gilgamesh', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(38, 'El tratado de paz mas antiguo del mundo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(38, 'Una queja del pesimo servicio por parte del rey a sus trabajadores', 0);")
        //Respuestas de pregunta 39
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(39, 'La batalla de Waterloo', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(39, 'La batalla del Álamo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(39, 'La batalla de Stalingrado', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(39, 'La batalla de peubla', 0);")
        //Respuestas de pregunta 40
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(40, 'Nilo', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(40, 'Amazonas', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(40, 'Tigris', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(40, 'Éufrates', 0);")
        //Respuestas de pregunta 41
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(41, 'Python', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(41, 'C#', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(41, 'Perl', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(41, 'go', 0);")
        //Respuestas de pregunta 42
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(42, 'Ada', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(42, 'PHP', 0)")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(42, 'c++', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(42, 'c', 0);")
        //Respuestas de pregunta 43
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(43, 'SCRUM', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(43, 'Por capas', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(43, 'Cascada', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(43, 'Desarrollo por componentes', 0);")
        //Respuestas de pregunta 44
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(44, 'Android Studio', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(44, 'Visual Studio Code', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(44, 'Atom', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(44, 'Sublime text', 0);")
        //Respuestas de pregunta 45
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(45, 'ciclo for', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(45, 'ciclo latente', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(45, 'ciclo de pruebas', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(45, 'ciclo de bus', 0);")
        //Respuestas de pregunta 46
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(46, 'Linux', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(46, 'Windows 10', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(46, 'Windows xp', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(46, 'Android', 0);")
        //Respuestas de pregunta 47
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(47, 'HTML5', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(47, 'JavaScript', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(47, 'R', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(47, 'go', 0);")
        //Respuestas de pregunta 48
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(48, 'React Native', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(48, 'Flutter', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(48, 'Kivy', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(48, 'Laravel', 0);")
        //Respuestas de pregunta 49
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(49, 'Kotlin', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(49, 'Swift', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(49, 'nodeJSs', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(49, 'PHP', 0);")
        //Respuestas de pregunta 50
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(50, 'DJango', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(50, 'Laravel', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(50, 'Codeigniter', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(50, 'Kivy', 0);")
        //Respuestas de pregunta 51
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(51, 'dulce, amargo, acido, salado y umami', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(51, 'rojo, verde, azul, naranja y celeste', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(51, 'desagradable, bueno, decepcionante, triste y jugoso', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(51, 'Liquido, gaseoso y solido', 0);")
        //Respuestas de pregunta 52
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(52, 'La antartida', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(52, 'Su corazon de ella :c', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(52, 'Malasia', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(52, 'Péru', 0);")
        //Respuestas de pregunta 53
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(53, 'Odiseo', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(53, 'Homero', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(53, 'Filipo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(53, 'El rey arturo', 0);")
        //Respuestas de pregunta 54
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(54, 'El amazonas', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(54, 'El nilo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(54, 'El rio de grijalva', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(54, 'Rio papaloapan', 0);")
        //Respuestas de pregunta 55
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(55, 'Isabel II', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(55, 'Alicia V', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(55, 'Bolena VI', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(55, 'Tricia VII', 0);")
        //Respuestas de pregunta 56
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(56, 'Autria', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(56, 'Asia', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(56, 'America', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(56, 'Africa', 0);")
        //Respuestas de pregunta 57
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(57, 'Grecia', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(57, 'Roma', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(57, 'Chile', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(57, 'Alemania', 0);")
        //Respuestas de pregunta 58
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(58, 'Mamifero', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(58, 'Pez', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(58, 'Reptil', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(58, 'Anfibio', 0);")
        //Respuestas de pregunta 59
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(59, 'verde, blanco y rojo', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(59, 'azul, blanco y rojo', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(59, 'verde, amarillo y negro', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(58, 'blanca con un punto rojo', 0);")
        //Respuestas de pregunta 60
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(60, '1945', 1);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(60, '1972', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(60, '1934', 0);")
        db.execSQL("INSERT INTO question_answers(id, text, correct_answer) VALUES(60, '1957', 0);")
    }
}

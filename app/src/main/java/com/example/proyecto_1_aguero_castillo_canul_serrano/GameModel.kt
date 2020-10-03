package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class GameModel(application: Application) : AndroidViewModel(application) {

    val misPreferencias = MyPreferences(getApplication())

    private var temaTodos = false;

    private var temaArte = misPreferencias.getTemaArte();
    private var temaCiencia = misPreferencias.getTemaCiencia();
    private var temaCine = misPreferencias.getTemaCine();
    private var temaHistoria = misPreferencias.getTemaHistoria();
    private var temaProgramacion = misPreferencias.getTemaProgramacion();
    private var themeCultura = misPreferencias.getTemaCultura();

    private var numeroPreguntas = misPreferencias.getCantidadPreguntas();
    private var dificultad = misPreferencias.getNivelEstablecido() //0->baja  1->media  2->alta
    private var numeroPistas = misPreferencias.getCantidadPistas()

    private var currentQuestion = 0
    private var answeredQuestions = 0
    private var correctQuestions: Float = 0f

    private val questions = listOf<Question>(
        Question(R.string.question_text_1, false, false),
        Question(R.string.question_text_2, false, false),
        Question(R.string.question_text_3, false, false),
        Question(R.string.question_text_4, false, false),
        Question(R.string.question_text_5, false, false),
        Question(R.string.question_text_6, true, false)
    )

    //Theme Questions
    private val arte_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Arte_1, listOf<Int>(R.string.r_question_Arte_1_1, R.string.r_question_Arte_1_2, R.string.r_question_Arte_1_3, R.string.r_question_Arte_1_4),R.string.r_question_Arte_1_2, "Arte",false),
        ThemeQuestion(R.string.question_Arte_2, listOf<Int>(R.string.r_question_Arte_2_1, R.string.r_question_Arte_2_2, R.string.r_question_Arte_2_3, R.string.r_question_Arte_2_4),R.string.r_question_Arte_2_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_3, listOf<Int>(R.string.r_question_Arte_3_1, R.string.r_question_Arte_3_2, R.string.r_question_Arte_3_3, R.string.r_question_Arte_3_4),R.string.r_question_Arte_3_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_4, listOf<Int>(R.string.r_question_Arte_4_1, R.string.r_question_Arte_4_2, R.string.r_question_Arte_4_3, R.string.r_question_Arte_4_4),R.string.r_question_Arte_4_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_5, listOf<Int>(R.string.r_question_Arte_5_1, R.string.r_question_Arte_5_2, R.string.r_question_Arte_5_3, R.string.r_question_Arte_5_4),R.string.r_question_Arte_5_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_6, listOf<Int>(R.string.r_question_Arte_6_1, R.string.r_question_Arte_6_2, R.string.r_question_Arte_6_3, R.string.r_question_Arte_6_4),R.string.r_question_Arte_6_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_7, listOf<Int>(R.string.r_question_Arte_7_1, R.string.r_question_Arte_7_2, R.string.r_question_Arte_7_3, R.string.r_question_Arte_7_4),R.string.r_question_Arte_7_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_8, listOf<Int>(R.string.r_question_Arte_8_1, R.string.r_question_Arte_8_2, R.string.r_question_Arte_8_3, R.string.r_question_Arte_8_4),R.string.r_question_Arte_8_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_9, listOf<Int>(R.string.r_question_Arte_9_1, R.string.r_question_Arte_9_2, R.string.r_question_Arte_9_3, R.string.r_question_Arte_9_4),R.string.r_question_Arte_9_2, "Arte", false),
        ThemeQuestion(R.string.question_Arte_10,listOf<Int>(R.string.r_question_Arte_10_1, R.string.r_question_Arte_10_2, R.string.r_question_Arte_10_3, R.string.r_question_Arte_10_4),R.string.r_question_Arte_10_2, "Arte", false)
    )

    private val history_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Historia_1, listOf<Int>(R.string.r_question_Historia_1_1, R.string.r_question_Historia_1_2, R.string.r_question_Historia_1_3, R.string.r_question_Historia_1_4),R.string.r_question_Historia_1_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_2, listOf<Int>(R.string.r_question_Historia_2_1, R.string.r_question_Historia_2_2, R.string.r_question_Historia_2_3, R.string.r_question_Historia_2_4),R.string.r_question_Historia_2_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_3, listOf<Int>(R.string.r_question_Historia_3_1, R.string.r_question_Historia_3_2, R.string.r_question_Historia_3_3, R.string.r_question_Historia_3_4),R.string.r_question_Historia_3_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_4, listOf<Int>(R.string.r_question_Historia_4_1, R.string.r_question_Historia_4_2, R.string.r_question_Historia_4_3, R.string.r_question_Historia_4_4),R.string.r_question_Historia_4_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_5, listOf<Int>(R.string.r_question_Historia_5_1, R.string.r_question_Historia_5_2, R.string.r_question_Historia_5_3, R.string.r_question_Historia_5_4),R.string.r_question_Historia_5_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_6, listOf<Int>(R.string.r_question_Historia_6_1, R.string.r_question_Historia_6_2, R.string.r_question_Historia_6_3, R.string.r_question_Historia_6_4),R.string.r_question_Historia_6_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_7, listOf<Int>(R.string.r_question_Historia_7_1, R.string.r_question_Historia_7_2, R.string.r_question_Historia_7_3, R.string.r_question_Historia_7_4),R.string.r_question_Historia_7_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_8, listOf<Int>(R.string.r_question_Historia_8_1, R.string.r_question_Historia_8_2, R.string.r_question_Historia_8_3, R.string.r_question_Historia_8_4),R.string.r_question_Historia_8_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_9, listOf<Int>(R.string.r_question_Historia_9_1, R.string.r_question_Historia_9_2, R.string.r_question_Historia_9_3, R.string.r_question_Historia_9_4),R.string.r_question_Historia_9_2, "Historia", false),
        ThemeQuestion(R.string.question_Historia_10,listOf<Int>(R.string.r_question_Historia_10_1, R.string.r_question_Historia_10_2, R.string.r_question_Historia_10_3, R.string.r_question_Historia_10_4),R.string.r_question_Historia_10_2, "Historia", false)
    )
    private val ciencia_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Ciencia_1, listOf<Int>(R.string.r_question_Ciencia_1_1, R.string.r_question_Ciencia_1_2, R.string.r_question_Ciencia_1_3, R.string.r_question_Ciencia_1_4),R.string.r_question_Ciencia_1_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_2, listOf<Int>(R.string.r_question_Ciencia_2_1, R.string.r_question_Ciencia_2_2, R.string.r_question_Ciencia_2_3, R.string.r_question_Ciencia_2_4),R.string.r_question_Ciencia_2_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_3, listOf<Int>(R.string.r_question_Ciencia_3_1, R.string.r_question_Ciencia_3_2, R.string.r_question_Ciencia_3_3, R.string.r_question_Ciencia_3_4),R.string.r_question_Ciencia_3_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_4, listOf<Int>(R.string.r_question_Ciencia_4_1, R.string.r_question_Ciencia_4_2, R.string.r_question_Ciencia_4_3, R.string.r_question_Ciencia_4_4),R.string.r_question_Ciencia_4_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_5, listOf<Int>(R.string.r_question_Ciencia_5_1, R.string.r_question_Ciencia_5_2, R.string.r_question_Ciencia_5_3, R.string.r_question_Ciencia_5_4),R.string.r_question_Ciencia_5_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_6, listOf<Int>(R.string.r_question_Ciencia_6_1, R.string.r_question_Ciencia_6_2, R.string.r_question_Ciencia_6_3, R.string.r_question_Ciencia_6_4),R.string.r_question_Ciencia_6_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_7, listOf<Int>(R.string.r_question_Ciencia_7_1, R.string.r_question_Ciencia_7_2, R.string.r_question_Ciencia_7_3, R.string.r_question_Ciencia_7_4),R.string.r_question_Ciencia_7_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_8, listOf<Int>(R.string.r_question_Ciencia_8_1, R.string.r_question_Ciencia_8_2, R.string.r_question_Ciencia_8_3, R.string.r_question_Ciencia_8_4),R.string.r_question_Ciencia_8_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_9, listOf<Int>(R.string.r_question_Ciencia_9_1, R.string.r_question_Ciencia_9_2, R.string.r_question_Ciencia_9_3, R.string.r_question_Ciencia_9_4),R.string.r_question_Ciencia_9_2, "Ciencia", false),
        ThemeQuestion(R.string.question_Ciencia_10,listOf<Int>(R.string.r_question_Ciencia_10_1, R.string.r_question_Ciencia_10_2, R.string.r_question_Ciencia_10_3, R.string.r_question_Ciencia_10_4),R.string.r_question_Ciencia_10_2, "Ciencia", false)
    )
    private val programacion_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Programación_1, listOf<Int>(R.string.r_question_Programación_1_1, R.string.r_question_Programación_1_2, R.string.r_question_Programación_1_3, R.string.r_question_Programación_1_4),R.string.r_question_Programación_1_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_2, listOf<Int>(R.string.r_question_Programación_2_1, R.string.r_question_Programación_2_2, R.string.r_question_Programación_2_3, R.string.r_question_Programación_2_4),R.string.r_question_Programación_2_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_3, listOf<Int>(R.string.r_question_Programación_3_1, R.string.r_question_Programación_3_2, R.string.r_question_Programación_3_3, R.string.r_question_Programación_3_4),R.string.r_question_Programación_3_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_4, listOf<Int>(R.string.r_question_Programación_4_1, R.string.r_question_Programación_4_2, R.string.r_question_Programación_4_3, R.string.r_question_Programación_4_4),R.string.r_question_Programación_4_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_5, listOf<Int>(R.string.r_question_Programación_5_1, R.string.r_question_Programación_5_2, R.string.r_question_Programación_5_3, R.string.r_question_Programación_5_4),R.string.r_question_Programación_5_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_6, listOf<Int>(R.string.r_question_Programación_6_1, R.string.r_question_Programación_6_2, R.string.r_question_Programación_6_3, R.string.r_question_Programación_6_4),R.string.r_question_Programación_6_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_7, listOf<Int>(R.string.r_question_Programación_7_1, R.string.r_question_Programación_7_2, R.string.r_question_Programación_7_3, R.string.r_question_Programación_7_4),R.string.r_question_Programación_7_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_8, listOf<Int>(R.string.r_question_Programación_8_1, R.string.r_question_Programación_8_2, R.string.r_question_Programación_8_3, R.string.r_question_Programación_8_4),R.string.r_question_Programación_8_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_9, listOf<Int>(R.string.r_question_Programación_9_1, R.string.r_question_Programación_9_2, R.string.r_question_Programación_9_3, R.string.r_question_Programación_9_4),R.string.r_question_Programación_9_2, "Programación", false),
        ThemeQuestion(R.string.question_Programación_10,listOf<Int>(R.string.r_question_Programación_10_1, R.string.r_question_Programación_10_2, R.string.r_question_Programación_10_3, R.string.r_question_Programación_10_4),R.string.r_question_Programación_10_2, "Programación", false)
    )
    //te
    private val cine_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Cine_1, listOf<Int>(R.string.r_question_Cine_1_1, R.string.r_question_Cine_1_2, R.string.r_question_Cine_1_3, R.string.r_question_Cine_1_4),R.string.r_question_Cine_1_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_2, listOf<Int>(R.string.r_question_Cine_2_1, R.string.r_question_Cine_2_2, R.string.r_question_Cine_2_3, R.string.r_question_Cine_2_4),R.string.r_question_Cine_2_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_3, listOf<Int>(R.string.r_question_Cine_3_1, R.string.r_question_Cine_3_2, R.string.r_question_Cine_3_3, R.string.r_question_Cine_3_4),R.string.r_question_Cine_3_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_4, listOf<Int>(R.string.r_question_Cine_4_1, R.string.r_question_Cine_4_2, R.string.r_question_Cine_4_3, R.string.r_question_Cine_4_4),R.string.r_question_Cine_4_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_5, listOf<Int>(R.string.r_question_Cine_5_1, R.string.r_question_Cine_5_2, R.string.r_question_Cine_5_3, R.string.r_question_Cine_5_4),R.string.r_question_Cine_5_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_6, listOf<Int>(R.string.r_question_Cine_6_1, R.string.r_question_Cine_6_2, R.string.r_question_Cine_6_3, R.string.r_question_Cine_6_4),R.string.r_question_Cine_6_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_7, listOf<Int>(R.string.r_question_Cine_7_1, R.string.r_question_Cine_7_2, R.string.r_question_Cine_7_3, R.string.r_question_Cine_7_4),R.string.r_question_Cine_7_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_8, listOf<Int>(R.string.r_question_Cine_8_1, R.string.r_question_Cine_8_2, R.string.r_question_Cine_8_3, R.string.r_question_Cine_8_4),R.string.r_question_Cine_8_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_9, listOf<Int>(R.string.r_question_Cine_9_1, R.string.r_question_Cine_9_2, R.string.r_question_Cine_9_3, R.string.r_question_Cine_9_4),R.string.r_question_Cine_9_2, "Cine", false),
        ThemeQuestion(R.string.question_Cine_10,listOf<Int>(R.string.r_question_Cine_10_1, R.string.r_question_Cine_10_2, R.string.r_question_Cine_10_3, R.string.r_question_Cine_10_4),R.string.r_question_Cine_10_2, "Cine", false)
    )
    private val culture_questions = listOf<ThemeQuestion>(
        ThemeQuestion(R.string.question_Cultura_1, listOf<Int>(R.string.r_question_Cultura_1_1, R.string.r_question_Cultura_1_2, R.string.r_question_Cultura_1_3, R.string.r_question_Cultura_1_4),R.string.r_question_Cultura_1_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_2, listOf<Int>(R.string.r_question_Cultura_2_1, R.string.r_question_Cultura_2_2, R.string.r_question_Cultura_2_3, R.string.r_question_Cultura_2_4),R.string.r_question_Cultura_2_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_3, listOf<Int>(R.string.r_question_Cultura_3_1, R.string.r_question_Cultura_3_2, R.string.r_question_Cultura_3_3, R.string.r_question_Cultura_3_4),R.string.r_question_Cultura_3_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_4, listOf<Int>(R.string.r_question_Cultura_4_1, R.string.r_question_Cultura_4_2, R.string.r_question_Cultura_4_3, R.string.r_question_Cultura_4_4),R.string.r_question_Cultura_4_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_5, listOf<Int>(R.string.r_question_Cultura_5_1, R.string.r_question_Cultura_5_2, R.string.r_question_Cultura_5_3, R.string.r_question_Cultura_5_4),R.string.r_question_Cultura_5_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_6, listOf<Int>(R.string.r_question_Cultura_6_1, R.string.r_question_Cultura_6_2, R.string.r_question_Cultura_6_3, R.string.r_question_Cultura_6_4),R.string.r_question_Cultura_6_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_7, listOf<Int>(R.string.r_question_Cultura_7_1, R.string.r_question_Cultura_7_2, R.string.r_question_Cultura_7_3, R.string.r_question_Cultura_7_4),R.string.r_question_Cultura_7_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_8, listOf<Int>(R.string.r_question_Cultura_8_1, R.string.r_question_Cultura_8_2, R.string.r_question_Cultura_8_3, R.string.r_question_Cultura_8_4),R.string.r_question_Cultura_8_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_9, listOf<Int>(R.string.r_question_Cultura_9_1, R.string.r_question_Cultura_9_2, R.string.r_question_Cultura_9_3, R.string.r_question_Cultura_9_4),R.string.r_question_Cultura_9_2, "Cultura", false),
        ThemeQuestion(R.string.question_Cultura_10,listOf<Int>(R.string.r_question_Cultura_10_1, R.string.r_question_Cultura_10_2, R.string.r_question_Cultura_10_3, R.string.r_question_Cultura_10_4),R.string.r_question_Cultura_10_2, "Cultura", false)
    )

    private val final_array2 = arrayListOf<ThemeQuestion>()
    private var final_questions_toshow = arrayListOf<ThemeQuestion>()

    fun showQuestions(){
        var finalList= arrayListOf<ThemeQuestion>()
        val listaOlo = arrayListOf<prueba>(
            prueba("Arte", 0),
            prueba("Ciencia", 0),
            prueba("Cine", 0),
            prueba("Historia", 0),
            prueba("Programación", 0),
            prueba("Cultura", 0)
        )
        var listaOlo2= arrayListOf<prueba>()


        for(element in final_array2){
            var cate= element.category

            when(cate){
                "Historia"->{
                    listaOlo.get(3).num+=1

                }
                "Ciencia"->{
                    listaOlo.get(1).num+=1
                }
                "Arte"->{
                    listaOlo.get(0).num+=1
                }
                "Programación"->{
                    listaOlo.get(4).num+=1
                }
                "Cine"->{
                    listaOlo.get(2).num+=1
                }
                "Cultura"->{
                    listaOlo.get(5).num+=1
                }
            }
        }



        for(element in listaOlo){
            if(element.num !=0){
                listaOlo2.add(element)
            }
        }

        var listCate= recu(numeroPreguntas, listaOlo2.size)

        for(i in 0..(listaOlo2.size-1)){
            for(j in 0..final_array2.size){
                if(j<listCate[i] && final_array2.get(j).category == listaOlo2.get(i).cate){
                    finalList.add(final_array2.get(j))
                }else{
                    for(l in 0..(listaOlo2.get(i).num-1)){
                        final_array2.removeAt(0)
                    }
                    break
                }
            }
        }

        final_questions_toshow = finalList
    }

    //funciones recursivas -
    val listaNums= arrayListOf<Int>()
    fun recu(numQ: Int, numC: Int): MutableList<Int> {

        return if (numQ - (numQ / numC) == 0) {
            //println(numQ)
            listaNums.add(numQ)
            return listaNums
        } else {
            //println(numQ/numC)
            listaNums.add(numQ / numC)
            recu((numQ - (numQ / numC)), (numC - 1))
        }
    }
    val listaNums2= arrayListOf<Int>()
    fun recu2(numQ: Int, numC: Int): MutableList<Int> {

        return if (numQ - (numQ / numC) == 0) {
            //println(numQ)
            listaNums2.add(numQ)
            return listaNums2
        } else {
            //println(numQ/numC)
            listaNums2.add(numQ / numC)
            recu2((numQ - (numQ / numC)), (numC - 1))
        }
    }

    //funcion para filtrar preguntas
    public fun filtrateQuestions()
    {
        if(!temaTodos){
            var numOfTrueThemes = 0 //la cantidad de temas elegidos
            var indexthemes = arrayListOf<Int>() //los indices de los temas elegidos
            var themesCheck = arrayOf(temaArte,temaCiencia,temaCine,temaHistoria,temaProgramacion,themeCultura)

            for ((i,value) in themesCheck.withIndex())
            {
                if(value){
                    //println(numOfTrueThemes)
                    indexthemes.add(i)
                    numOfTrueThemes++
                }
            }
            var countsArrayDiv = recu2(10,numOfTrueThemes)
            println(countsArrayDiv)
            //println(numOfTrueThemes)
            //println(countsArrayDiv)
            for (i in 0 until numOfTrueThemes)
            {
                //print(i)
                //println(indexthemes[i])
                when (indexthemes[i]){
                    0 -> chooseQuestions(arte_questions,countsArrayDiv[i])
                    1 -> chooseQuestions(ciencia_questions,countsArrayDiv[i])
                    2 -> chooseQuestions(cine_questions,countsArrayDiv[i])
                    3 -> chooseQuestions(history_questions,countsArrayDiv[i])
                    4 -> chooseQuestions(programacion_questions,countsArrayDiv[i])
                    5 -> chooseQuestions(culture_questions,countsArrayDiv[i])
                }
            }
        }
        println(final_array2)
    }

    var randoms = arrayListOf<Int>()
    fun chooseQuestions(questions:List<ThemeQuestion>, count:Int)
    {

        for (i in 0 until count)
        {
            var iquesToShow = makeRandom()
            //validar si se repite??
            final_array2.add(questions[iquesToShow])
        }
        randoms = arrayListOf<Int>()
    }
    fun makeRandom() :Int
    {

        var num = (0..9).random()
        var i = 0
        outer@while (i < randoms.size){
            while (num == randoms[i]){
                num = (0..9).random()
                i = 0
                continue@outer
            }
            i++
        }

        randoms.add(num)
        return num
    }

    fun getQuestionsToShow():List<ThemeQuestion>{ return final_questions_toshow}

    //view
    fun numOfQuestions(): Int { return numeroPreguntas }
    fun currentQuestionNum(): Int { return currentQuestion }
    fun currentQuestionObj(): ThemeQuestion { return final_questions_toshow[currentQuestion] }

    fun correctQuestions(): Float { return correctQuestions }
    fun increaseCorrectQuestions() { correctQuestions++ }

    fun answeredQuestions(): Int { return answeredQuestions }
    fun increaseAnsweredQuestions() { answeredQuestions++ }

    fun nextQuestion() { currentQuestion = (currentQuestion + 1) % final_questions_toshow.size }
    fun previousQuestion() { currentQuestion = (currentQuestion - 1) % final_questions_toshow.size }

    fun updateCurrentQuestion(value: Int) { currentQuestion = value }

    fun getDificult(): Int { return dificultad}

}

data class prueba(var cate: String, var num: Int)
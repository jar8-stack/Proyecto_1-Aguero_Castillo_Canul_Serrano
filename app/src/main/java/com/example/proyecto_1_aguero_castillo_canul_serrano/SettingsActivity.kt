package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

    var cantidadPreguntas = ""
    var cantidadPistas = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val misPreferencias = MyPreferences(this)

        val misCantidadDePreguntas = arrayOf("5", "6", "7", "8", "9", "10")
        val cantidadDePistas = arrayOf("1","2","3")

        vspnopreguntas.setAdapter( ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, misCantidadDePreguntas))
        vspnopistas.setAdapter( ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cantidadDePistas))

        vspnopreguntas.setSelection((vspnopreguntas.getAdapter() as ArrayAdapter<String?>).getPosition("" + misPreferencias.getCantidadPreguntas()))
        vspnopistas.setSelection((vspnopistas.getAdapter() as ArrayAdapter<String?>).getPosition("" + misPreferencias.getCantidadPistas()))

        vspnopreguntas.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                /*


                Toast.makeText(
                    adapterView.context,
                    "Selecciono " + adapterView.getItemAtPosition(position) as String + " preguntas por juego",
                    Toast.LENGTH_SHORT
                ).show()*/
                cantidadPreguntas = adapterView.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // vacio
            }
        })

        vspnopistas.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                /*


                Toast.makeText(
                    adapterView.context,
                    "Selecciono " + adapterView.getItemAtPosition(position) as String + " pistas por juego",
                    Toast.LENGTH_SHORT
                ).show()*/
                cantidadPistas = adapterView.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // vacio
            }
        })

        if(misPreferencias.getNivelEstablecido() == 0){ //FACIL
            rbtnFacil.isChecked = true
        }else if(misPreferencias.getNivelEstablecido() == 1){ //MEDIO
            rbtnMedio.isChecked = true
        }else if(misPreferencias.getNivelEstablecido() == 2){ //DIFICIL
            rbtnDificil.isChecked = true
        }

        if(misPreferencias.getPistasActivas()){
            vtbpistas.isChecked = true
            txvNoPistas.isVisible = true
            vspnopistas.isVisible = true
        }else{
            vtbpistas.isChecked = false
            txvNoPistas.isVisible = false
            vspnopistas.isVisible = false
        }

        vtbpistas.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // The toggle is enabled
                txvNoPistas.isVisible = true
                vspnopistas.isVisible = true
            } else {
                // The toggle is disabled
                txvNoPistas.isVisible = false
                vspnopistas.isVisible = false
            }
        }

        btnGuardarPreferencias.setOnClickListener { view ->

            misPreferencias.setCantidadPreguntas(cantidadPreguntas.toInt())

            misPreferencias.setCantidadPistas(cantidadPistas.toInt())

            if(rbtnFacil.isChecked){
                misPreferencias.setNivelEstablecido(0)
            }else if(rbtnMedio.isChecked){
                misPreferencias.setNivelEstablecido(1)
            }else if(rbtnDificil.isChecked){
                misPreferencias.setNivelEstablecido(2)
            }

            misPreferencias.setPistasActivas(vtbpistas.isChecked)
        }
    }
}
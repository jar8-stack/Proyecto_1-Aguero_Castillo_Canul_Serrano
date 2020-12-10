package com.example.proyecto_1_aguero_castillo_canul_serrano

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_1_aguero_castillo_canul_serrano.Preferences.MyPreferences
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {

    var cantidadPreguntas = ""
    var cantidadPistas = ""

    var temasActivados = 1

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

        vcbarte.isChecked = misPreferencias.getTemaArte()
        vcbciencai.isChecked = misPreferencias.getTemaCiencia()
        vcbcine.isChecked = misPreferencias.getTemaCine()
        vcbhistoria.isChecked = misPreferencias.getTemaHistoria()
        vcbprogramacion.isChecked = misPreferencias.getTemaProgramacion()
        vcbcultura.isChecked = misPreferencias.getTemaCultura()

        if(misPreferencias.getNivelEstablecido() == 0){ //FACIL
            rbtnFacil.isChecked = true
        }else if(misPreferencias.getNivelEstablecido() == 1){ //MEDIO
            rbtnMedio.isChecked = true
        }else if(misPreferencias.getNivelEstablecido() == 2){ //DIFICIL
            rbtnDificil.isChecked = true
        }

        if(misPreferencias.getPistasActivas()){
            vtbpistas.isChecked = true
            txvNoPistas.visibility = View.VISIBLE
            vspnopistas.visibility = View.VISIBLE
        }else{
            vtbpistas.isChecked = false
            txvNoPistas.visibility = View.INVISIBLE
            vspnopistas.visibility = View.INVISIBLE
        }

        vtbpistas.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // The toggle is enabled
                txvNoPistas.visibility = View.VISIBLE
                vspnopistas.visibility = View.VISIBLE
            } else {
                // The toggle is disabled
                txvNoPistas.visibility = View.INVISIBLE
                vspnopistas.visibility = View.INVISIBLE
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

            misPreferencias.setTemaArte(vcbarte.isChecked)
            misPreferencias.setTemaCiencia(vcbciencai.isChecked)
            misPreferencias.setTemaCine(vcbcine.isChecked)
            misPreferencias.setTemaHistoria(vcbhistoria.isChecked)
            misPreferencias.setTemaProgramacion(vcbprogramacion.isChecked)
            misPreferencias.setTemaCultura(vcbcultura.isChecked)
        }

        vswtodos.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                vcbarte.isChecked = true
                vcbciencai.isChecked = true
                vcbcine.isChecked = true
                vcbhistoria.isChecked = true
                vcbprogramacion.isChecked = true
                vcbcultura.isChecked = true
            }
        }

        vcbarte.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbarte.isActivated = false
            }
        }

        vcbciencai.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbciencai.isActivated = false
            }
        }

        vcbcine.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbcine.isActivated = false
            }
        }

        vcbhistoria.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbhistoria.isActivated = false
            }
        }

        vcbprogramacion.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbprogramacion.isActivated = false
            }
        }

        vcbcultura.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                temasActivados++
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }else{
                temasActivados--
                vswtodos.isChecked = false
                Log.d("TEMASACTIVADOS",""+temasActivados)
            }

            if(temasActivados == 6){
                vswtodos.isChecked = true
            }else if(temasActivados == 0){
                vcbcultura.isActivated = false
            }
        }
    }
}
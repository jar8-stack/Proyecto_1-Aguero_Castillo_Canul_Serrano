package com.example.proyecto_1_aguero_castillo_canul_serrano.Preferences

import android.content.Context

class MyPreferences(context: Context) {

    val PREFERENCES_NAME = "SharedPreferencesGame"
    val PREFERENCES_CANTIDAD_PREGUNTAS = "SharedPreferencesCantidadPreguntas"
    val PREFERENCES_NIVEL_ESTABLECIDO = "SharedPreferencesNivelEstablecido"
    val PREFERENCES_CANTIDAD_PISTAS = "SharedPreferencesCantidadPistas"
    val PREFERENCES_PISTAS_ACTIVAS = "SharedPreferencesPistasActivas"

    val PREFERENCES_TEMA_ARTE = "SharedPreferencesTemaArte"
    val PREFERENCES_TEMA_CIENCIA = "SharedPreferencesTemaCiencia"
    val PREFERENCES_TEMA_CINE = "SharedPreferencesTemaCine"
    val PREFERENCES_TEMA_HISTORIA = "SharedPreferencesTemaHistoria"
    val PREFERENCES_TEMA_PROGRAMACION = "SharedPreferencesTemaProgramacion"
    val PREFERENCES_TEMA_CULTURA = "SharedPreferencesTemaCultura"

    val PREFERENCES_NOMBRE_USUARIO = "SharedPreferencesNombreUsuario"
    val PREFERENCES_ID_USUARIO = "SharedPreferencesIdUsuario"
    val PREFERENCES_LOGEADO = "SharedPreferencesLogeado"

    val preferences = context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE)

    fun getLogeado() : Boolean{
        return preferences.getBoolean(PREFERENCES_LOGEADO, false)
    }

    fun setLogeado(Login : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_LOGEADO, Login)
        editor.apply()
    }

    fun getNombreUsuario() : String? {
        return preferences.getString(PREFERENCES_NOMBRE_USUARIO,"");
    }

    fun setNombreUsuario(Nombre : String){
        val editor = preferences.edit()
        editor.putString(PREFERENCES_NOMBRE_USUARIO, Nombre)
        editor.apply()
    }

    fun getIdUsuario() : String? {
        return preferences.getString(PREFERENCES_ID_USUARIO,"");
    }

    fun setIdUsuario(Id : String){
        val editor = preferences.edit()
        editor.putString(PREFERENCES_ID_USUARIO, Id)
        editor.apply()
    }

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

    fun getTemaArte() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_ARTE, false)
    }

    fun setTemaArte(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_ARTE, Activo)
        editor.apply()
    }

    fun getTemaCiencia() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_CIENCIA, false)
    }

    fun setTemaCiencia(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_CIENCIA, Activo)
        editor.apply()
    }

    fun getTemaCine() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_CINE, false)
    }

    fun setTemaCine(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_CINE, Activo)
        editor.apply()
    }

    fun getTemaHistoria() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_HISTORIA, false)
    }

    fun setTemaHistoria(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_HISTORIA, Activo)
        editor.apply()
    }

    fun getTemaProgramacion() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_PROGRAMACION, true)
    }

    fun setTemaProgramacion(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_PROGRAMACION, Activo)
        editor.apply()
    }

    fun getTemaCultura() : Boolean{
        return preferences.getBoolean(PREFERENCES_TEMA_CULTURA, false)
    }

    fun setTemaCultura(Activo : Boolean){
        val editor = preferences.edit()
        editor.putBoolean(PREFERENCES_TEMA_CULTURA, Activo)
        editor.apply()
    }

    fun getTemasTodos() : Boolean{
        return (preferences.getBoolean(PREFERENCES_TEMA_ARTE, false) && preferences.getBoolean(PREFERENCES_TEMA_CIENCIA, false)
                && preferences.getBoolean(PREFERENCES_TEMA_CINE, false) && preferences.getBoolean(PREFERENCES_TEMA_HISTORIA, false)
                && preferences.getBoolean(PREFERENCES_TEMA_PROGRAMACION, true) && preferences.getBoolean(PREFERENCES_TEMA_CULTURA, false))
    }

    /*
    PARA PODER REALIZAR LA CONSULTA DE LOS DATOS SE INSTANCIA NUESTRA CLASE MyPreference en donde queremos usar las varaibles, de esta forma:

    val misPreferencias = MyPreferences(this)

    OJO: La linea anterior va dentro del metodo OnCreate()

    UNA VEZ YA INSTANCIADO NUESTRA CLASE MyPreference PODEMOS ACCEDER A LOS DATOS CON LOS METODOS DE ESTA CLASE, USANDO LA SIGUIENTE FORMA:

    misPreferencias.getCantidadPreguntas()

    TAMBIEN PUDIENDO ASIGNANDO A VARIABLES:

    val miVariable = misPreferencias.getCantidadPreguntas()

    OJO: Solo podemos usar los metodos que inicien con get ya que esos solo sirven para obtener, los metodos que inicen con set solo deben usarse en SettingActivity.
     */
}
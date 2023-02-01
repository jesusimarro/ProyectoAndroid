package com.example.appfootball.Retrofit

class Repositorio {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun listadoCompeticiones() = retrofit.ListadoCompeticiones()
    suspend fun equiposCompeticion(code: String) = retrofit.ListadoEquiposCompeticion(code)
    suspend fun partidosCompeticion(code: String) = retrofit.ListadoPartidosCompeticion(code)
    suspend fun goleadoresCompeticion(code: String) = retrofit.ListadoGoleadoresCompeticion(code)
    suspend fun plantilla(id: Int) = retrofit.ListadoPlantilla(id)
    suspend fun infoPlantilla(id: Int) = retrofit.InfoPlantilla(id)
    suspend fun clasificacion(code: String) = retrofit.tablaClasificacion(code)
    suspend fun jugadorSeleccionado(id: Int) = retrofit.jugadorSeleccionado(id)


}
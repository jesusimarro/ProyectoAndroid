package com.example.appfootball.Retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfootball.DataClass.Competiciones.Goleadoers.Scorer
import com.example.appfootball.DataClass.Equipos.Listado.Squad
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.DataClass.Equipos.Partidos.Matche
import com.example.appfootball.DataClass.Jugadores.Jugador
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Table
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutbolViewModel : ViewModel() {

    private val repositorio = Repositorio()

    val listado_competiciones = MutableLiveData<ArrayList<Competition>>()
    val listado_equipos = MutableLiveData<ArrayList<Team>>()
    val listado_partidos = MutableLiveData<ArrayList<Matche>>()
    val listado_goleadores = MutableLiveData<ArrayList<Scorer>>()
    val listado_plantilla = MutableLiveData<ArrayList<Squad>>()
    val listado_clasificacion = MutableLiveData<ArrayList<Table>>()

    val competicion_seleccionada = MutableLiveData<Competition>()
    val jugadorSeleccionado = MutableLiveData<Squad>()
    val datojugador = MutableLiveData<Jugador>()
    val equipo_seleccionado = MutableLiveData<Team>()
    val goleadorSeleccionado = MutableLiveData<Scorer>()
    val clasificacion_seleccionada = MutableLiveData<Table>()


    fun getListaCompeticiones(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.listadoCompeticiones()

            if (response.isSuccessful) {
                val respuesta = response.body()
                val listaCompeticiones = respuesta?.competitions
                listaCompeticiones?.let {
                    listado_competiciones.postValue(it)
                }
            }
        }
    }

    fun getListaEquiposCompeticion(code: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.equiposCompeticion(code)

            if (response.isSuccessful) {
                val respuesta = response.body()
                val listaEquipos = respuesta?.teams
                listaEquipos?.let {
                    listado_equipos.postValue(it)
                }
            }
        }
    }

    fun getListaPartidosCompeticion(code: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.partidosCompeticion(code)

            if (response.isSuccessful) {
                val respuesta = response.body()
                val listaPartidos = respuesta?.matches
                listaPartidos?.let {
                    listado_partidos.postValue(it)
                }
            }
        }
    }

    fun getListaGoleadoresCompeticion(code: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.goleadoresCompeticion(code)

            if (response.isSuccessful) {
                val respuesta = response.body()
                val listaGoleadores = respuesta?.scorers
                listaGoleadores?.let {
                    listado_goleadores.postValue(it)
                }
            }
        }
    }

    fun getPlantillaEquipo(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.plantilla(id)

            if (response.isSuccessful) {
                val respuesta = response.body()
                val listaPlantilla = respuesta?.squad
                val infoplantilla = Jugador("","",0,"","","","","",7)
                listaPlantilla?.let {
                    listado_plantilla.postValue(it)
                }
                infoplantilla.let {
                    datojugador.postValue(it)
                }
            }
        }
    }

    fun getTablaClasificacion(code: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.clasificacion(code)

            if (response.isSuccessful) {
                val respuesta = response.body()
                if (respuesta != null) {
                    val regularSeason = respuesta.standings
                    if (regularSeason != null) {
                        val listaClasificacion = regularSeason[0].table

                        listaClasificacion?.let {
                            listado_clasificacion.postValue(it)
                        }
                    }
                }
            }
        }
    }
}
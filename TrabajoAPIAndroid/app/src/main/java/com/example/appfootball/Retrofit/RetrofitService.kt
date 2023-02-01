package com.example.appfootball.Retrofit

import com.example.appfootball.DataClass.Competiciones.Goleadoers.Goleadores
import com.example.appfootball.DataClass.Equipos.Listado.Equipo
import com.example.appfootball.DataClass.Equipos.Partidos.Partidos
import com.example.appfootball.DataClass.Equipos.Prueba.Equipazo
import com.example.appfootball.DataClass.Jugadores.Jugador
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Estadistica
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Standing
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Table
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competicion_Listado
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val token = "3cc09d432eb4427d882de4955426e0ec"

interface RetrofitService {

    @Headers("X-Auth-Token: $token", "Content-Type: application/json;charset=UTF-8")
    @GET("competitions")
    suspend fun ListadoCompeticiones() : Response<Competicion_Listado>

    @Headers("X-Auth-Token: $token")
    @GET("competitions/{code}/teams")
    suspend fun ListadoEquiposCompeticion(@Path("code") code: String): Response<Equipo>

    @Headers("X-Auth-Token: $token")
    @GET("teams/{id}")
    suspend fun ListadoPlantilla(@Path("id") id: Int): Response<Equipazo>

    @Headers("X-Auth-Token: $token")
    @GET("persons/{id}")
    suspend fun InfoPlantilla(@Path("id") id: Int): Response<Jugador>

    @Headers("X-Auth-Token: $token", "X-Unfold-Goals: true")
    @GET("competitions/{code}/matches")
    suspend fun ListadoPartidosCompeticion(@Path("code") code: String): Response<Partidos>

    @Headers("X-Auth-Token: $token", "X-Unfold-Goals: true")
    @GET("competitions/{code}/scorers")
    suspend fun ListadoGoleadoresCompeticion(@Path("code") code: String): Response<Goleadores>

    @Headers("X-Auth-Token: $token")
    @GET("competitions/{code}/standings")
    suspend fun tablaClasificacion(@Path("code") code: String): Response<Estadistica>

    @Headers("X-Auth-Token: $token")
    @GET("/v4/persons/{id}")
    suspend fun jugadorSeleccionado(@Path("id") id: Int): Response<Standing>
}
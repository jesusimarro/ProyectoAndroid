package com.example.proyectoapi.DataClass.Competiciones.Estadisticas


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.appfootball.DataClass.Equipos.Listado.Team

@Parcelize
data class Table(
    @SerializedName("draw")
    val draw: Int? ,
    @SerializedName("form")
    val form: String? ,
    @SerializedName("goalDifference")
    val goalDifference: Int? ,
    @SerializedName("goalsAgainst")
    val goalsAgainst: Int? ,
    @SerializedName("goalsFor")
    val goalsFor: Int? ,
    @SerializedName("lost")
    val lost: Int? ,
    @SerializedName("playedGames")
    val playedGames: Int? ,
    @SerializedName("points")
    val points: Int? ,
    @SerializedName("position")
    val position: Int? ,
    @SerializedName("team")
    val team: Team? ,
    @SerializedName("won")
    val won: Int?
) : Parcelable
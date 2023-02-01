package com.example.proyectoapi.DataClass.Competiciones.Estadisticas


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.proyectoapi.DataClass.Competiciones.Listado.Area

@Parcelize
data class Estadistica(
    @SerializedName("area")
    val area: Area?,
    @SerializedName("competition")
    val competition: Competition?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("season")
    val season: Season?,
    @SerializedName("standings")
    val standings: List<Standing>?
) : Parcelable
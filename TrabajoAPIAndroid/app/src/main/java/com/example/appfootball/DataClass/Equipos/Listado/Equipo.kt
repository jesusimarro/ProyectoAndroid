package com.example.appfootball.DataClass.Equipos.Listado


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Equipo(
    @SerializedName("competition")
    val competition: Competition?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("season")
    val season: Season?,
    @SerializedName("teams")
    val teams: ArrayList<Team>?
) : Parcelable
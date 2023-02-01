package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Partidos(
    @SerializedName("competition")
    val competition: Competition?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("matches")
    val matches: ArrayList<Matche>?,
    @SerializedName("resultSet")
    val resultSet: ResultSet?
) : Parcelable
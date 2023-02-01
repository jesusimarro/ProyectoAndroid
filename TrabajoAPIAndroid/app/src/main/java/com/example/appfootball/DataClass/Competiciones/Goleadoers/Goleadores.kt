package com.example.appfootball.DataClass.Competiciones.Goleadoers


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Goleadores(
    @SerializedName("competition")
    val competition: Competition?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?,
    @SerializedName("scorers")
    val scorers: ArrayList<Scorer>?,
    @SerializedName("season")
    val season: Season?
) : Parcelable
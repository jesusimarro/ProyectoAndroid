package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Filters(
    @SerializedName("matchday")
    val matchday: String?,
    @SerializedName("season")
    val season: String?
) : Parcelable
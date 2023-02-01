package com.example.appfootball.DataClass.Equipos.Listado


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Filters(
    @SerializedName("season")
    val season: String?
) : Parcelable
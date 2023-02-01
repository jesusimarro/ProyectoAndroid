package com.example.proyectoapi.DataClass.Competiciones.Estadisticas


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Filters(
    @SerializedName("season")
    val season: String?
) : Parcelable
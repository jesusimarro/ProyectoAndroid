package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.proyectoapi.DataClass.Competiciones.Listado.Winner

@Parcelize
data class Season(
    @SerializedName("currentMatchday")
    val currentMatchday: Int?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("stages")
    val stages: List<String>?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("winner")
    val winner: Winner?
) : Parcelable
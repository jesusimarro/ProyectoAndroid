package com.example.proyectoapi.DataClass.Competiciones.Listado


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Competicion_Listado(
    @SerializedName("competitions")
    val competitions: ArrayList<Competition>?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("filters")
    val filters: Filters?
) : Parcelable
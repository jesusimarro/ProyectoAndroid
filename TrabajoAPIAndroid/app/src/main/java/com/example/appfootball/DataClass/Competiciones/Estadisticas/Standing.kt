package com.example.proyectoapi.DataClass.Competiciones.Estadisticas

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Standing(
    @SerializedName("group")
    val group: String?,
    @SerializedName("stage")
    val stage: String?,
    @SerializedName("table")
    val table: ArrayList<Table>?,
    @SerializedName("type")
    val type: String?
) : Parcelable
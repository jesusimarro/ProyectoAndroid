package com.example.appfootball.DataClass.Competiciones.Goleadoers


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Filters(
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("season")
    val season: String?
) : Parcelable
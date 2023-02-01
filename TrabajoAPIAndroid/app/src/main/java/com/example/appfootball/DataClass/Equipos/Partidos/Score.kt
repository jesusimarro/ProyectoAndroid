package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Score(
    @SerializedName("away")
    val away: Int?,
    @SerializedName("home")
    val home: Int?
) : Parcelable
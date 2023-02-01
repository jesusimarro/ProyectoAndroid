package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ScoreX(
    @SerializedName("away")
    val away: String?,
    @SerializedName("home")
    val home: String?
) : Parcelable
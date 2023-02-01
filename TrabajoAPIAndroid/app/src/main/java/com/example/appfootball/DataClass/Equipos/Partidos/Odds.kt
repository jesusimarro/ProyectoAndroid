package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Odds(
    @SerializedName("awayWin")
    val awayWin: Double?,
    @SerializedName("draw")
    val draw: Double?,
    @SerializedName("homeWin")
    val homeWin: Double?
) : Parcelable
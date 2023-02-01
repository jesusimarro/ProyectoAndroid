package com.example.appfootball.DataClass.Competiciones.Goleadoers


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Scorer(
    @SerializedName("assists")
    val assists: Int?,
    @SerializedName("goals")
    val goals: Int?,
    @SerializedName("penalties")
    val penalties: Int?,
    @SerializedName("player")
    val player: Player?,
    @SerializedName("team")
    val team: Team?
) : Parcelable
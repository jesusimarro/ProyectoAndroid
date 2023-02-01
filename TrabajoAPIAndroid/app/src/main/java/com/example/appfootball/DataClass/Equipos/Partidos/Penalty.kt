package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Penalty(
    @SerializedName("player")
    val player: Player?,
    @SerializedName("score")
    val score: ScoreX?,
    @SerializedName("scored")
    val scored: Boolean?,
    @SerializedName("team")
    val team: TeamX?
) : Parcelable
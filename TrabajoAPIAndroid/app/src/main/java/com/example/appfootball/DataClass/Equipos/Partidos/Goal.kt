package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Goal(
    @SerializedName("assist")
    val assist: String?,
    @SerializedName("injuryTime")
    val injuryTime: String?,
    @SerializedName("minute")
    val minute: Int?,
    @SerializedName("score")
    val score: Score?,
    @SerializedName("scorer")
    val scorer: Scorer?,
    @SerializedName("team")
    val team: Team?,
    @SerializedName("type")
    val type: String?
) : Parcelable
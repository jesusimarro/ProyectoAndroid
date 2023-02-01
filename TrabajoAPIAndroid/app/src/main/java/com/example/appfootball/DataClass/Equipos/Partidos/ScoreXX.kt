package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ScoreXX(
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("fullTime")
    val fullTime: FullTime?,
    @SerializedName("halfTime")
    val halfTime: HalfTime?,
    @SerializedName("winner")
    val winner: String?
) : Parcelable
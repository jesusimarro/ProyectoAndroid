package com.example.appfootball.DataClass.Jugadores


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Contract(
    @SerializedName("start")
    val start: String?,
    @SerializedName("until")
    val until: String?
) : Parcelable
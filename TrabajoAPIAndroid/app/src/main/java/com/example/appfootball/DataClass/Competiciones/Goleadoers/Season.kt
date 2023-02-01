package com.example.appfootball.DataClass.Competiciones.Goleadoers


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Season(
    @SerializedName("currentMatchday")
    val currentMatchday: Int?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("stages")
    val stages: List<String>?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("winner")
    val winner: String?
) : Parcelable
package com.example.appfootball.DataClass.Equipos.Prueba


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.appfootball.DataClass.Equipos.Listado.Squad

@Parcelize
data class Equipazo(
    @SerializedName("address")
    val address: String?,
    @SerializedName("area")
    val area: Area?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("coach")
    val coach: Coach?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("marketValue")
    val marketValue: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("runningCompetitions")
    val runningCompetitions: List<RunningCompetition>?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("squad")
    val squad: ArrayList<Squad>?,
//    @SerializedName("staff")
//    val staff: List<Any>?,
    @SerializedName("tla")
    val tla: String?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("website")
    val website: String?
) : Parcelable
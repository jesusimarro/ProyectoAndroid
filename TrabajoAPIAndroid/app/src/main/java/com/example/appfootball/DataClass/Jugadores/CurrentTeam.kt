package com.example.appfootball.DataClass.Jugadores


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CurrentTeam(
    @SerializedName("address")
    val address: String?,
    @SerializedName("area")
    val area: Area?,
    @SerializedName("clubColors")
    val clubColors: String?,
    @SerializedName("contract")
    val contract: Contract?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("runningCompetitions")
    val runningCompetitions: List<RunningCompetition>?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val tla: String?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("website")
    val website: String?
) : Parcelable
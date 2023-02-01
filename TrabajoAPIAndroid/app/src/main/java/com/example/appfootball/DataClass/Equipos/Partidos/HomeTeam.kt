package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class HomeTeam(
    @SerializedName("bench")
    val bench: List<String>?,
    @SerializedName("coach")
    val coach: CoachX?,
    @SerializedName("crest")
    val crest: String?,
    @SerializedName("formation")
    val formation: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("leagueRank")
    val leagueRank: Int?,
    @SerializedName("lineup")
    val lineup: List<String>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("shortName")
    val shortName: String?,
    @SerializedName("tla")
    val tla: String?
) : Parcelable
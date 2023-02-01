package com.example.appfootball.DataClass.Equipos.Partidos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Matche(
    @SerializedName("area")
    val area: Area?,
    @SerializedName("attendance")
    val attendance: String?,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam?,
    @SerializedName("bookings")
    val bookings: List<String>?,
    @SerializedName("competition")
    val competition: CompetitionX?,
    @SerializedName("goals")
    val goals: List<Goal>?,
    @SerializedName("group")
    val group: String?,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("injuryTime")
    val injuryTime: Int?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("matchday")
    val matchday: Int?,
    @SerializedName("minute")
    val minute: String?,
    @SerializedName("odds")
    val odds: Odds?,
    @SerializedName("penalties")
    val penalties: List<Penalty>?,
    @SerializedName("referees")
    val referees: List<Referee>?,
    @SerializedName("score")
    val score: ScoreXX?,
    @SerializedName("season")
    val season: Season?,
    @SerializedName("stage")
    val stage: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("substitutions")
    val substitutions: List<String>?,
    @SerializedName("utcDate")
    val utcDate: String?,
    @SerializedName("venue")
    val venue: String?
) : Parcelable
package com.example.appfootball.DataClass.Jugadores


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Jugador(
    /*@SerializedName("currentTeam")
    val currentTeam: CurrentTeam?,*/
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("lastUpdated")
    val lastUpdated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("shirtNumber")
    val shirtNumber: Int?
) : Parcelable
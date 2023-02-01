package com.example.appfootball.DataClass.Equipos.Prueba


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Coach(
    @SerializedName("contract")
    val contract: Contract?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nationality")
    val nationality: String?
) : Parcelable
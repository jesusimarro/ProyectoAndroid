package com.example.appfootball.DataClass.Equipos.Listado


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.example.appfootball.DataClass.Equipos.Prueba.ContractX

@Parcelize
data class Squad(
    @SerializedName("contract")
    val contract: ContractX?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("marketValue")
    val marketValue: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("shirtNumber")
    val shirtNumber: Int?
) : Parcelable
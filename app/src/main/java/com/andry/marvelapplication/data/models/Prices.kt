package com.andry.marvelapplication.data.models


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Prices(
    @SerializedName("price")
    val price: Double,
    @SerializedName("type")
    val type: String
)
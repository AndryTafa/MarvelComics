package com.andry.marvelapplication.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Series(
    @PrimaryKey
    @SerializedName("seriesId")
    val seriesId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("resourceURI")
    val resourceURI: String
)
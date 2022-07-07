package com.andry.marvelapplication.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Thumbnail(
    @PrimaryKey
    @SerializedName("thumbnailId")
    val thumbnailId: Int,
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String,
)
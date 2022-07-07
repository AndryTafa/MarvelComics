package com.andry.marvelapplication.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.RawValue

@Parcelize
@Entity
data class Comic(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("format")
    val format: String,
    @Embedded
    @SerializedName("thumbnail")
    val thumbnail: @RawValue Thumbnail,
    @Embedded
    @SerializedName("series")
    val series: @RawValue Series,
): Parcelable
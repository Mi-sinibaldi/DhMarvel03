package com.example.dhmarvel03.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MarvelComicsResult(
    val code: Int,
    val data: Data
)

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: CommicsResult
)

@Parcelize
data class CommicsResult(
    @SerializedName("id")
    val id: Int,

    @SerializedName("thumbnail")
    val thumbnail: Thumbnail
): Parcelable

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
): Parcelable

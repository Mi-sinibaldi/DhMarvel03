package com.example.dhmarvel03.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MarvelComicsResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: ComicsData
) : Parcelable

@Parcelize
data class ComicsData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicsResult>
) : Parcelable

@Parcelize
data class ComicsResult(
    @SerializedName("id")
    val id: Int,

    @SerializedName("description")
    val description: String?,

    @SerializedName("title")
    val title: String,

    @SerializedName("modified")
    val modified: String,

    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,

    @SerializedName("pageCount")
    val pageCount: Int,

    @SerializedName("prices")
    val prices: List<Price>?,

    @SerializedName("images")
    val images: List<Image>?,
) : Parcelable

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
) : Parcelable

@Parcelize
data class Price(
    val type: String,
    val price: Double
) : Parcelable

@Parcelize
data class Image(
    val path: String,
    val extension: String
) : Parcelable
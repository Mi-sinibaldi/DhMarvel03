package com.example.dhmarvel03.model

data class MarvelComicsResult(
    val code: Int,
    val data: Data
)

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: Results
)

data class Results(
    val id: Int,
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val path: String,
    val extension: String
)

package com.example.dhmarvel03.remote

import com.example.dhmarvel03.model.MarvelComicsResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("ts") timeStamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Response<MarvelComicsResult>
}
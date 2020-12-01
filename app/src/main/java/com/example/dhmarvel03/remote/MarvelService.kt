package com.example.dhmarvel03.remote

import com.example.dhmarvel03.model.MarvelComicsResult
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {
    @GET("v1/public/comics?apikey=0a1444fd46f89ab6b6652968d3c273f4")
    suspend fun getComics(): Response<MarvelComicsResult>
}
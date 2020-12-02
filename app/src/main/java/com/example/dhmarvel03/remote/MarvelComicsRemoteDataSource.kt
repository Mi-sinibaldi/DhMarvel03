package com.example.dhmarvel03.remote

import javax.inject.Inject

class MarvelComicsRemoteDataSource @Inject constructor(
    private val marvelService: MarvelService
) : BaseDataSource() {

    suspend fun getComics(timeStamp: String, apiKey: String, hash: String) =
        getResult { marvelService.getComics(timeStamp, apiKey, hash) }

}
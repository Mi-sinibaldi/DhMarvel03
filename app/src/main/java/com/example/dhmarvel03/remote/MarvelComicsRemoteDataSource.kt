package com.example.dhmarvel03.remote

import javax.inject.Inject

class MarvelComicsRemoteDataSource @Inject constructor(
    private val marvelService: MarvelService
) : BaseDataSource() {

    suspend fun getComics() = getResult { marvelService.getComics() }

}
package com.example.dhmarvel03.repository

import com.example.dhmarvel03.remote.MarvelComicsRemoteDataSource
import com.example.githubapp.utils.performGetOperation
import javax.inject.Inject

class MarvelComicsRepository @Inject constructor(
    private val remoteDataSource: MarvelComicsRemoteDataSource
) {

    fun getComics(timeStamp:String, apiKey: String, hash:String) = performGetOperation(
        networkCall = { remoteDataSource.getComics(timeStamp,apiKey,hash) }
    )
}
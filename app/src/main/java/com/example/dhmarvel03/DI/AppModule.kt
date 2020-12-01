package com.example.dhmarvel03.DI

import com.example.dhmarvel03.remote.MarvelComicsRemoteDataSource
import com.example.dhmarvel03.remote.MarvelService
import com.example.dhmarvel03.repository.MarvelComicsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideGithubItemService(retrofit: Retrofit): MarvelService =
        retrofit.create(MarvelService::class.java)

    @Singleton
    @Provides
    fun provideGithubRemoteDataSource(
        marvelService: MarvelService
    ) = MarvelComicsRemoteDataSource(marvelService)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: MarvelComicsRemoteDataSource) =
        MarvelComicsRepository(remoteDataSource)

}
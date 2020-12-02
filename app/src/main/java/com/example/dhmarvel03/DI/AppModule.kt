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
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Singleton


private const val KEY_PRIVATE = "26c85b031a298aaf59a7438bec22572fd89caf1d"
private const val KEY_PUBLIC = "0a1444fd46f89ab6b6652968d3c273f4"

private var timeStamp: String = System.currentTimeMillis().toString()

const val TIME_STAMP_KEY = "ts"
const val HASH_KEY = "hash"
const val API_KEY = "apikey"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    var url = HttpUrl.parse("https://gateway.marvel.com:443/")

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(
            url?.newBuilder()
                ?.addQueryParameter(TIME_STAMP_KEY, timeStamp)
                ?.addQueryParameter(API_KEY, KEY_PUBLIC)
                ?.addQueryParameter(HASH_KEY, generateHash(timeStamp, KEY_PUBLIC, KEY_PRIVATE))
                ?.build()
        )
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

fun generateHash(timestamp: String, publicKey: String, privateKey: String): String {
    try {
        val value = timestamp + privateKey + publicKey
        val md5Encoder = MessageDigest.getInstance("MD5")
        val digest = md5Encoder.digest(value.toByteArray())
        return digest.fold("", { str, it -> str + "%02x".format(it) })
    } catch (e: NoSuchAlgorithmException) {
        throw Exception("cannot generate the api key", e)
    }
}



package com.example.dhmarvel03.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.dhmarvel03.repository.MarvelComicsRepository
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

private const val KEY_PRIVATE = "26c85b031a298aaf59a7438bec22572fd89caf1d"
private const val KEY_PUBLIC = "0a1444fd46f89ab6b6652968d3c273f4"

class MarvelComicsViewModel @ViewModelInject constructor(
    private val repository: MarvelComicsRepository
) : ViewModel() {
    private var timeStamp: String = System.currentTimeMillis().toString()

    val comics = repository.getComics(
        timeStamp, KEY_PUBLIC, generateHash(
            timeStamp,
            KEY_PUBLIC,
            KEY_PRIVATE
        )
    )

    private fun generateHash(timestamp: String, publicKey: String, privateKey: String): String {
        try {
            val value = timestamp + privateKey + publicKey
            val md5Encoder = MessageDigest.getInstance("MD5")
            val digest = md5Encoder.digest(value.toByteArray())
            return digest.fold("", { str, it -> str + "%02x".format(it) })
        } catch (e: NoSuchAlgorithmException) {
            throw Exception("cannot generate the api key", e)
        }
    }
}
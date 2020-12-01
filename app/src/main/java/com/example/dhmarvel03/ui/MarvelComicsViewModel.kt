package com.example.dhmarvel03.ui

import androidx.lifecycle.ViewModel
import com.example.dhmarvel03.repository.MarvelComicsRepository
import androidx.hilt.lifecycle.ViewModelInject

class MarvelComicsViewModel @ViewModelInject constructor(
    private val repository: MarvelComicsRepository
) : ViewModel() {
    val comics = repository.getComics()
}
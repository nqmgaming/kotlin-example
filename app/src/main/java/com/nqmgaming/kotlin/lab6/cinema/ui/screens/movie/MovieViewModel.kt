package com.nqmgaming.kotlin.lab6.cinema.ui.screens.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nqmgaming.kotlin.lab6.cinema.model.entities.movie.Movie
import com.nqmgaming.kotlin.lab6.cinema.model.entities.movie.getListMovies

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: MutableLiveData<List<Movie>> = _movies

    init {
        _movies.value = Movie().getListMovies()
    }

}
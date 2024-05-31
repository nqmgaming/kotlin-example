package com.nqmgaming.kotlin.lab6.cinema.presentation.screens.movie

import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie

data class MovieScreenState(
    val movies: List<Movie> = emptyList(),
    val selectedMovie: Movie? = null,
    val isLoading: Boolean = false
)
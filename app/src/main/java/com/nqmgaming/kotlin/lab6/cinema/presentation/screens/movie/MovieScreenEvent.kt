package com.nqmgaming.kotlin.lab6.cinema.presentation.screens.movie

import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie

sealed class MovieScreenEvent {
    data object OnLoad : MovieScreenEvent()
    data class OnMovieSelected(val movie: Movie) : MovieScreenEvent()
}
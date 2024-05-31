package com.nqmgaming.kotlin.lab6.cinema.domain.repository

import com.nqmgaming.kotlin.lab6.cinema.core.utils.Resources
import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<Resources<List<Movie>>>

    fun getMovieById(id: Int): Flow<Resources<Movie>>

    fun addMovie(movie: Movie): Flow<Resources<Movie>>

    fun updateMovie(movie: Movie): Flow<Resources<Movie>>
}
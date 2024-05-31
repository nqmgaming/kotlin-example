package com.nqmgaming.kotlin.lab6.cinema.data.mapper

import com.nqmgaming.kotlin.lab6.cinema.data.remote.dto.MovieDTO
import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie

fun MovieDTO.toDomain() = Movie(
    filmId = filmId,
    title = title,
    genre = genre,
    rating = rating,
    releaseDate = releaseDate,
    duration = duration,
    director = director,
    cast = cast,
    synopsis = synopsis,
    poster = poster
)

fun Movie.toDTO() = MovieDTO(
    filmId = filmId,
    title = title,
    genre = genre,
    rating = rating,
    releaseDate = releaseDate,
    duration = duration,
    director = director,
    cast = cast,
    synopsis = synopsis,
    poster = poster
)
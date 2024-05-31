package com.nqmgaming.kotlin.lab6.cinema.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    val filmId: String = "",
    val title: String = "",
    val genre: String = "",
    val rating: Float = 0.0f,
    val releaseDate: String = "",
    val duration: Int = 0,
    val director: String = "",
    val cast: List<String> = emptyList(),
    val synopsis: String = "",
    val poster: String = ""
)

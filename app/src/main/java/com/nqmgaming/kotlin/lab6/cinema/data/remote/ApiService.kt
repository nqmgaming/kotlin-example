package com.nqmgaming.kotlin.lab6.cinema.data.remote

import com.nqmgaming.kotlin.lab6.cinema.data.remote.dto.MovieDTO
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface ApiService {
    @GET("movies")
    suspend fun getMovies(): List<MovieDTO>

    @GET("movies/{id}")
    suspend fun getMovieById(id: Int): MovieDTO

    @POST("movies")
    suspend fun addMovie(@Body movie: MovieDTO): MovieDTO

}
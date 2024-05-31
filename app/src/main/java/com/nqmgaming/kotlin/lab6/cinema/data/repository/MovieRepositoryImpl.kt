package com.nqmgaming.kotlin.lab6.cinema.data.repository

import android.util.Log
import coil.network.HttpException
import com.nqmgaming.kotlin.lab6.cinema.core.utils.Resources
import com.nqmgaming.kotlin.lab6.cinema.data.mapper.toDTO
import com.nqmgaming.kotlin.lab6.cinema.data.mapper.toDomain
import com.nqmgaming.kotlin.lab6.cinema.data.remote.ApiService
import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie
import com.nqmgaming.kotlin.lab6.cinema.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApi: ApiService
) : MovieRepository {

    private val TAG = "MovieRepositoryImpl"
    override fun getMovies(): Flow<Resources<List<Movie>>> {
        return flow {
            emit(Resources.Loading(true))

            val movieList = try {
                movieApi.getMovies()
            } catch (e: IOException) {
                Log.e(TAG, "getMovies: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            } catch (e: HttpException) {
                Log.e(TAG, "getMovies: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            }

            if (movieList != null) {
                emit(Resources.Loading(false))
            }

            movieList.let { listing ->
                println("Listing: $listing")
                emit(Resources.Success(data = listing?.map { it.toDomain() }))
                emit(Resources.Loading(false))

            }

        }
    }

    override fun getMovieById(id: Int): Flow<Resources<Movie>> {
        return flow {
            emit(Resources.Loading(true))

            val movie = try {
                movieApi.getMovieById(id)
            } catch (e: IOException) {
                Log.e(TAG, "getMovieById: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            } catch (e: HttpException) {
                Log.e(TAG, "getMovieById: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            }

            if (movie != null) {
                emit(Resources.Loading(false))
            }

            movie.let { movieDto ->
                emit(Resources.Success(data = movieDto?.toDomain()))
                emit(Resources.Loading(false))

            }
        }
    }

    override fun addMovie(movie: Movie): Flow<Resources<Movie>> {
        return flow {
            emit(Resources.Loading(true))

            val movieDto = try {
                movieApi.addMovie(movie.toDTO())
            } catch (e: IOException) {
                Log.e(TAG, "addMovie: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            } catch (e: HttpException) {
                Log.e(TAG, "addMovie: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            }

            if (movieDto != null) {
                emit(Resources.Loading(false))
            }

            movieDto.let { movieDto ->
                emit(Resources.Success(data = movieDto?.toDomain()))
                emit(Resources.Loading(false))

            }
        }
    }

    override fun updateMovie(movie: Movie): Flow<Resources<Movie>> {
        return flow {
            emit(Resources.Loading(true))

            val movieDto = try {
                movieApi.addMovie(movie.toDTO())
            } catch (e: IOException) {
                Log.e(TAG, "updateMovie: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            } catch (e: HttpException) {
                Log.e(TAG, "updateMovie: ${e.stackTraceToString()}")
                emit(Resources.Error("An error occurred while fetching data"))
                null
            }

            if (movieDto != null) {
                emit(Resources.Loading(false))
            }

            movieDto.let { movieDto ->
                emit(Resources.Success(data = movieDto?.toDomain()))
                emit(Resources.Loading(false))

            }
        }
    }
}
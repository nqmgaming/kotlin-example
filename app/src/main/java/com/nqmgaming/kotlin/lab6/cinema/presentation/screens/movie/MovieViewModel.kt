package com.nqmgaming.kotlin.lab6.cinema.presentation.screens.movie

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nqmgaming.kotlin.lab6.cinema.core.utils.Resources
import com.nqmgaming.kotlin.lab6.cinema.domain.model.movie.Movie
import com.nqmgaming.kotlin.lab6.cinema.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _state = mutableStateOf(MovieScreenState())
    val state: State<MovieScreenState> = _state

    fun onEvent(event: MovieScreenEvent) {
        when (event) {
            is MovieScreenEvent.OnLoad -> loadMovies()
            is MovieScreenEvent.OnMovieSelected -> selectMovie(event.movie)
        }
    }

    private fun selectMovie(movie: Movie) {

    }

    private fun loadMovies() {
        viewModelScope.launch {
            movieRepository.getMovies().collect { result ->
                when (result) {
                    is Resources.Loading -> {
                        _state.value = _state.value.copy(isLoading = result.isLoading)
                    }

                    is Resources.Success -> {
                        println("Data in View model  ${result.data}")
                        result.data?.let { listings ->
                            _state.value = _state.value.copy(
                                movies = listings
                            )
                        }
                    }

                    is Resources.Error -> {
                        _state.value = _state.value.copy(isLoading = false)
                    }
                }
            }
        }
    }

}
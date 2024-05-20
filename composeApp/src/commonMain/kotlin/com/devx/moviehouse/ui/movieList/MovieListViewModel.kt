package com.devx.moviehouse.ui.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devx.moviehouse.networking.MovieDatabaseService
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(private val movieDatabaseService: MovieDatabaseService) : ViewModel() {

    private val _data: MutableStateFlow<String> = MutableStateFlow(value = "")
    val data: StateFlow<String> = _data.asStateFlow()

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() {
        viewModelScope.launch {
            movieDatabaseService.getTrendingMovies(type = "movie", category = "popular")
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}
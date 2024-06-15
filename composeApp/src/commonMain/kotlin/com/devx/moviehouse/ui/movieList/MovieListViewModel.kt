package com.devx.moviehouse.ui.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devx.moviehouse.domain.useCase.GetPopularMoviesUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieListViewModel(private val getPopularMovies: GetPopularMoviesUseCase) : ViewModel() {

    private val _homeUiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(value = HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        // Pass dispatcher
        viewModelScope.launch {
            _homeUiState.update {
                it.copy(isLoading = true)
            }
            getPopularMovies(movieType = "movie", movieCategory = "top_rated", pageNo = "1")
                .onSuccess { response ->
                    _homeUiState.update {
                        it.copy(popularMovieList = response.movieList, isLoading = false)
                    }
                }
                .onFailure {
                    _homeUiState.update {
                        it.copy(popularMovieList = it.popularMovieList, isLoading = false)
                    }
                }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}
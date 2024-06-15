package com.devx.moviehouse.ui.movieList

import com.devx.moviehouse.domain.model.MovieData

data class HomeUiState(
    val isLoading: Boolean = false,

    val popularMovieList: List<MovieData> = emptyList(),
    val errorMassage: String = "",
)
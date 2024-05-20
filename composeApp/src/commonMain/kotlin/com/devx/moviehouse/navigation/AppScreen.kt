package com.devx.moviehouse.navigation

sealed class AppScreen(val route: String) {
    data object MovieList : AppScreen("movie_list")
    data object MovieDetails : AppScreen("movie_details/{movieId}") {
        fun navigate(movieId: Int): String = "movie_details/${movieId}"
    }

    data object Popular : AppScreen("popular")
    data object TvSeries : AppScreen("tv_series")
}
package com.devx.moviehouse.ui.movieList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MovieListScreen(
    homeUiState: HomeUiState,
    navigateToMovieDetails: (movieId: Int) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (homeUiState.isLoading)
            CircularProgressIndicator()
        else {
            AutoSwipeImagePager(mediaList = homeUiState.popularMovieList)
        }
    }
}
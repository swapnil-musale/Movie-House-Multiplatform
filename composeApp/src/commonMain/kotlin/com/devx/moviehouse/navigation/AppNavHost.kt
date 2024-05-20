package com.devx.moviehouse.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.devx.moviehouse.ui.MovieDetailsScreen
import com.devx.moviehouse.ui.PopularScreen
import com.devx.moviehouse.ui.TvSeriesScreen
import com.devx.moviehouse.ui.movieList.MovieListScreen

@Composable
internal fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        navController = navController,
        startDestination = AppScreen.MovieList.route
    ) {
        composable(route = AppScreen.MovieList.route) {
            MovieListScreen {
                navController.navigate(route = AppScreen.MovieDetails.navigate(movieId = 1))
            }
        }

        composable(route = AppScreen.Popular.route) {
            PopularScreen()
        }

        composable(route = AppScreen.TvSeries.route) {
            TvSeriesScreen()
        }

        composable(
            route = AppScreen.MovieDetails.route,
            arguments = listOf(navArgument("movieId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getInt("movieId") ?: 0
            MovieDetailsScreen(movieId = movieId)
        }
    }
}
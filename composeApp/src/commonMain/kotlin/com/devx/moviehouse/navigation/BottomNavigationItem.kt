package com.devx.moviehouse.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Stars
import androidx.compose.material.icons.outlined.Tv
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.ui.graphics.vector.ImageVector

internal sealed class BottomNavigationItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {
    data object MovieList : BottomNavigationItem(
        route = AppScreen.MovieList.route,
        title = "Movies",
        selectedIcon = Icons.Rounded.Home,
        unSelectedIcon = Icons.Outlined.Home
    )

    data object Popular : BottomNavigationItem(
        route = AppScreen.Popular.route,
        title = "Popular",
        selectedIcon = Icons.Rounded.Stars,
        unSelectedIcon = Icons.Outlined.Stars
    )

    data object TVSeries : BottomNavigationItem(
        route = AppScreen.TvSeries.route,
        title = "TV Series",
        selectedIcon = Icons.Rounded.Tv,
        unSelectedIcon = Icons.Outlined.Tv
    )
}

internal val bottomNavigationItems = listOf(
    BottomNavigationItem.MovieList,
    BottomNavigationItem.Popular,
    BottomNavigationItem.TVSeries,
)
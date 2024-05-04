package com.devx.moviehouse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devx.moviehouse.navigation.AppBottomNavigationBar
import com.devx.moviehouse.theme.MovieHouseTheme

@Composable
internal fun MovieHouseApp(dynamicColor: Boolean = false) {
    MovieHouseTheme(dynamicColor = dynamicColor) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntry?.destination?.route

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    AppBottomNavigationBar(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                },
            ) { paddingValues ->
                AppNavHost(navController = navController, paddingValues = paddingValues)
            }
        }
    }
}
package com.devx.moviehouse.app.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.devx.moviehouse.navigation.bottomNavigationItems

@Composable
fun AppBottomNavigationBar(navController: NavController, currentDestination: String?) {

    val showBottomNavigationBar by remember(key1 = currentDestination) {
        mutableStateOf(
            bottomNavigationItems.any {
                it.route == currentDestination
            }
        )
    }

    AnimatedVisibility(visible = showBottomNavigationBar) {
        NavigationBar {
            bottomNavigationItems.forEach { item ->
                val isSelected = item.route == currentDestination

                NavigationBarItem(
                    selected = isSelected,
                    colors = NavigationBarItemDefaults.colors(indicatorColor = MaterialTheme.colorScheme.background),
                    label = {
                        Text(text = item.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.unSelectedIcon,
                            contentDescription = item.title,
                        )
                    },
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().route.orEmpty()) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        }
    }
}
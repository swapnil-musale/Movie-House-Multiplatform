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
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.devx.moviehouse.app.navigation.AppBottomNavigationBar
import com.devx.moviehouse.navigation.AppNavHost
import com.devx.moviehouse.theme.MovieHouseTheme
import okio.FileSystem
import org.koin.compose.KoinContext

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun MovieHouseApp(dynamicColor: Boolean = false) {
    KoinContext {
        MovieHouseTheme(dynamicColor = dynamicColor) {
            setSingletonImageLoaderFactory { context ->
                getAsyncImageLoader(context = context)
            }
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
}

fun getAsyncImageLoader(context: PlatformContext) =
    ImageLoader.Builder(context = context)
        .memoryCachePolicy(policy = CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context = context, percent = 0.3)
                .strongReferencesEnabled(enable = true)
                .build()
        }
        .diskCachePolicy(policy = CachePolicy.ENABLED)
        .networkCachePolicy(policy = CachePolicy.ENABLED)
        .diskCache { newDiskCache() }
        .crossfade(enable = true)
        .logger(logger = DebugLogger())
        .build()

fun newDiskCache(): DiskCache {
    return DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(1024L * 1024 * 1024) // 512MB
        .build()
}
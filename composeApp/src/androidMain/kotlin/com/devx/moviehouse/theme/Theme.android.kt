package com.devx.moviehouse.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat
import com.devx.moviehouse.MovieHouseApp

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
    val view = LocalView.current
    LaunchedEffect(key1 = isDark) {
        val window = (view.context as Activity).window
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = isDark
            isAppearanceLightNavigationBars = isDark
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
internal actual fun dynamicLightColorScheme(): ColorScheme =
    dynamicLightColorScheme(MovieHouseApp.INSTANCE.applicationContext)

@RequiresApi(Build.VERSION_CODES.S)
internal actual fun dynamicDarkColorScheme(): ColorScheme =
    dynamicDarkColorScheme(MovieHouseApp.INSTANCE.applicationContext)
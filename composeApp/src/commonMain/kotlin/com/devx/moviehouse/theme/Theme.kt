package com.devx.moviehouse.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.devx.kdeviceinfo.rememberDeviceInfoXState

internal val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
internal fun MovieHouseTheme(
    systemIsDark: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val isDarkState = remember { mutableStateOf(systemIsDark) }
    val deviceInfoXState = rememberDeviceInfoXState()

    val isDynamicColorSupport = if (deviceInfoXState.isAndroid) {
        deviceInfoXState.androidInfo.version.sdkInt >= deviceInfoXState.androidInfo.VERSION_CODES.S
    } else {
        false
    }

    val colorScheme = when {
        dynamicColor && isDynamicColorSupport -> {
            if (isDarkState.value) {
                dynamicDarkColorScheme()
            } else {
                dynamicLightColorScheme()
            }
        }

        isDarkState.value -> darkColorScheme()
        else -> lightColorScheme()
    }

    CompositionLocalProvider(LocalThemeIsDark provides isDarkState) {
        val isDark by isDarkState
        SystemAppearance(isDark = !isDark)

        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
internal expect fun dynamicLightColorScheme(): ColorScheme
internal expect fun dynamicDarkColorScheme(): ColorScheme

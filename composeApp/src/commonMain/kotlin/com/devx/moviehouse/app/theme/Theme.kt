@file:Suppress("FunctionName")

package com.devx.moviehouse.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.devx.kdeviceinfo.rememberDeviceInfoXState

@Composable
internal fun MovieHouseTheme(
    systemIsDark: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val deviceInfoXState = rememberDeviceInfoXState()

    val isDynamicColorSupport = if (deviceInfoXState.isAndroid) {
        deviceInfoXState.androidInfo.version.sdkInt >= deviceInfoXState.androidInfo.VERSION_CODES.S
    } else {
        false
    }

    val colorScheme = when {
        dynamicColor && isDynamicColorSupport -> {
            if (systemIsDark) {
                DynamicDarkColorScheme()
            } else {
                DynamicLightColorScheme()
            }
        }

        systemIsDark -> darkColorScheme()
        else -> lightColorScheme()
    }

    SystemAppearance(isDark = !systemIsDark)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@Composable
internal expect fun SystemAppearance(isDark: Boolean)
internal expect fun DynamicLightColorScheme(): ColorScheme
internal expect fun DynamicDarkColorScheme(): ColorScheme

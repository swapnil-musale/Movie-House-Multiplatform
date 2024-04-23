package com.devx.moviehouse.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

@Composable
internal actual fun SystemAppearance(isDark: Boolean) {
    LaunchedEffect(key1 = isDark) {
        UIApplication.sharedApplication.setStatusBarStyle(
            if (isDark) UIStatusBarStyleDarkContent else UIStatusBarStyleLightContent
        )
    }
}
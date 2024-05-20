@file:Suppress("FunctionName", "unused")

import androidx.compose.ui.window.ComposeUIViewController
import com.devx.moviehouse.MovieHouseApp
import com.devx.moviehouse.di.KoinInitializer
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    MovieHouseApp()
}

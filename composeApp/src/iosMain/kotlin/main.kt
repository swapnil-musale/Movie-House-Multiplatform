@file:Suppress("FunctionName", "unused")

import androidx.compose.ui.window.ComposeUIViewController
import com.devx.moviehouse.app.MovieHouseApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    MovieHouseApp()
}

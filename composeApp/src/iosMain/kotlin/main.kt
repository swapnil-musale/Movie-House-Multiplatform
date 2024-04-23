import androidx.compose.ui.window.ComposeUIViewController
import com.devx.moviehouse.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    App()
}

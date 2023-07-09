package mhw.inventory

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

/**
 * Displays an error message dialog if there is a message string.
 */
@Composable
fun ErrorDialog(
    title: String,
    message: String? = null,
    onConfirm: () -> Unit
) {
    BaseDialog(titleText = title, onConfirm = onConfirm) {
        message?.let {
            Text(text = it)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorDialogPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            ErrorDialog(
                title = "Error Dialog",
                message = "Failed to create an object of some kind and need to revert and stuff",
                onConfirm = {}
            )
        }
    }
}

@Preview(name = "Light Mode - No Message")
@Preview(name = "Dark Mode - No Message", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorDialogNoMessagePreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            ErrorDialog(
                title = "Error Dialog",
                onConfirm = {}
            )
        }
    }
}

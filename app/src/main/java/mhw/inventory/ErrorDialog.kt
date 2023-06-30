package mhw.inventory

import android.content.res.Configuration
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

/**
 * Displays an error message dialog if there is a message string.
 */
@Composable
fun ErrorDialog(title: String, message: String?, onConfirm: () -> Unit) {
    message?.let {
        AlertDialog(
            title = {
                Text(text = title)
            },
            text = {
                Text(text = it)
            },
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(stringResource(android.R.string.ok))
                }
            }
        )
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

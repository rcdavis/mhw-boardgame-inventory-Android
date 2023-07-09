package mhw.inventory

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun BaseDialog(
    titleText: String,
    onConfirm: () -> Unit,
    onCancel: (() -> Unit)? = null,
    content: @Composable (() -> Unit)? = null
) {
    AlertDialog(
        title = { Text(titleText) },
        text = content,
        onDismissRequest = onCancel ?: {},
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(stringResource(android.R.string.ok))
            }
        },
        dismissButton = {
            onCancel?.let {
                TextButton(onClick = it) {
                    Text(stringResource(android.R.string.cancel))
                }
            }
        }
    )
}

@Composable
fun BaseDialog(
    @StringRes titleTextId: Int,
    onConfirm: () -> Unit,
    onCancel: (() -> Unit)? = null,
    content: @Composable (() -> Unit)? = null
) {
    BaseDialog(
        titleText = stringResource(titleTextId),
        onConfirm = onConfirm,
        onCancel = onCancel,
        content = content
    )
}

@Preview(name = "Light Mode", group = "Base")
@Preview(
    name = "Dark Mode",
    group = "Base",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun BaseDialogPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            BaseDialog(
                titleText = "Base Dialog",
                onConfirm = {},
                onCancel = {}
            ) {
                Text("Failed to create an object of some kind and need to revert and stuff.")
            }
        }
    }
}

@Preview(name = "Light Mode - No Cancel", group = "No Cancel")
@Preview(
    name = "Dark Mode - No Cancel",
    group = "No Cancel",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun BaseDialogNoCancelPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            BaseDialog(
                titleText = "Base Dialog",
                onConfirm = {}
            ) {
                Text("Failed to create an object of some kind and need to revert and stuff.")
            }
        }
    }
}

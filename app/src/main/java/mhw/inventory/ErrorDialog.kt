package mhw.inventory

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

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
                    Text(text = stringResource(android.R.string.ok))
                }
            }
        )
    }
}

package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.R
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMaterialScreen(
    onConfirm: (String) -> Unit,
    onCancel: () -> Unit
) {
    var materialName by remember { mutableStateOf("") }

    AlertDialog(
        title = {
            Text(stringResource(R.string.add_material_title))
        },
        text = {
            TextField(
                value = materialName,
                onValueChange = { materialName = it },
                label = {
                    Text(stringResource(R.string.add_material_name_title))
                },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
        },
        onDismissRequest = onCancel,
        confirmButton = {
            TextButton(onClick = { onConfirm(materialName.trim()) }) {
                Text(stringResource(android.R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text(stringResource(android.R.string.cancel))
            }
        }
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddMaterialScreenPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            AddMaterialScreen(
                onConfirm = {},
                onCancel = {}
            )
        }
    }
}

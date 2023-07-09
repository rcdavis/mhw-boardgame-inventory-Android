package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.BaseDialog
import mhw.inventory.R
import mhw.inventory.TextInputField
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun AddMaterialScreen(
    onCancel: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var materialName by remember { mutableStateOf("") }

    BaseDialog(
        titleTextId = R.string.add_material_title,
        onConfirm = { onConfirm(materialName.trim()) },
        onCancel = onCancel
    ) {
        Column {
            TextInputField(
                labelTextId = R.string.add_material_name_title,
                valueText = materialName
            ) {
                materialName = it
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddMaterialScreenPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            AddMaterialScreen(onCancel = {}) {}
        }
    }
}

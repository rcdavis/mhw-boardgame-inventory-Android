package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.BaseDialog
import mhw.inventory.R
import mhw.inventory.TextInputField
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.getMockMaterials

@Composable
fun DeleteMaterialScreen(
    material: Material,
    onCancel: (() -> Unit)? = null,
    onConfirm: (Material) -> Unit
) {
    BaseDialog(
        titleTextId = R.string.delete_material_title,
        onConfirm = { onConfirm(material) },
        onCancel = onCancel
    ) {
        Text(stringResource(R.string.delete_material_text, material.name))
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeleteMaterialScreenPreview() {
    val materials = getMockMaterials()

    MHWBoardGameInventoryTheme {
        Surface {
            DeleteMaterialScreen(
                material = materials.first(),
                onConfirm = {},
                onCancel = {}
            )
        }
    }
}

@Preview(name = "Light Mode - No Cancel")
@Preview(name = "Dark Mode - No Cancel", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeleteMaterialScreenNoCancelPreview() {
    val materials = getMockMaterials()

    MHWBoardGameInventoryTheme {
        Surface {
            DeleteMaterialScreen(
                material = materials.last(),
                onConfirm = {}
            )
        }
    }
}

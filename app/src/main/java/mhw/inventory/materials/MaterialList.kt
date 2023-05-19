package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.InventoryListItem
import mhw.inventory.getMockMaterials
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun MaterialList(
    materials: List<Material>,
    onUpdate: (Material) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(materials) { material ->
            InventoryListItem(
                text = material.name,
                count = material.amount,
                onCountChange = {
                    material.amount = it
                    onUpdate(material)
                }
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialListPreview() {
    val materials = getMockMaterials()

    MHWBoardGameInventoryTheme {
        Surface {
            MaterialList(
                materials = materials,
                onUpdate = {}
            )
        }
    }
}

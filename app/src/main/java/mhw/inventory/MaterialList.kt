package mhw.inventory

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun MaterialList(
    materials: List<Material>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(materials) { material ->
            MaterialListItem(
                text = material.name,
                count = material.amount,
                onAdd = { material.amount++ },
                onRemove = { material.amount-- }
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
                materials = materials
            )
        }
    }
}

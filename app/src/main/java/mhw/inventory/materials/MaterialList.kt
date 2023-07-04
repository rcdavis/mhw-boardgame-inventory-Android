package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mhw.inventory.InventoryListItem
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.getMockMaterials

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MaterialList(
    materials: List<Material>,
    onUpdate: (Material, Int) -> Unit,
    onLongPress: (Material) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(materials) { material ->
            InventoryListItem(
                text = material.name,
                count = material.amount,
                onCountChange = {
                    onUpdate(material, it)
                },
                modifier = modifier
                    .combinedClickable(
                        onClick = {},
                        onLongClick = { onLongPress(material) }
                    )
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeToDismissBg(dismissState: DismissState) {
    val color by animateColorAsState(
        when (dismissState.targetValue) {
            DismissValue.Default -> Color.White
            else -> Color.Red
        }
    )

    val scale by animateFloatAsState(
        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1.0f
    )

    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(horizontal = Dp(20.0f))
    ) {
        Icon(
            Icons.Default.Delete,
            contentDescription = null,
            modifier = Modifier.scale(scale)
        )
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
                onUpdate = { _, _ -> },
                onLongPress = {}
            )
        }
    }
}

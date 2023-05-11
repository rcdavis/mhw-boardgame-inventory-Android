package mhw.inventory

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun MaterialScreen(
    materials: List<Material>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = stringResource(R.string.materials_title))
        MaterialList(materials = materials)
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialScreenPreview() {
    val materials = listOf(
        Material("Carbalite Ore", 2),
        Material("Malachite Ore", 1),
        Material("Dragonite Ore", 4)
    )
    MHWBoardGameInventoryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MaterialScreen(materials = materials)
        }
    }
}

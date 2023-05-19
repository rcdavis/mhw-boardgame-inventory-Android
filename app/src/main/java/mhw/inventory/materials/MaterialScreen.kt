package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.R
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun MaterialScreen(
    modifier: Modifier = Modifier,
    materialViewModel: MaterialViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        materialViewModel.fetchMaterials()
    }

    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = stringResource(R.string.materials_title),
            style = MaterialTheme.typography.headlineMedium
        )
        MaterialList(
            materials = materialViewModel.materials,
            onUpdate = { materialViewModel.updateMaterial(it) }
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialScreenPreview() {
    val materialViewModel: MaterialViewModel = viewModel {
        MaterialViewModel(
            MaterialRepository()
        )
    }

    MHWBoardGameInventoryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MaterialScreen(
                materialViewModel = materialViewModel
            )
        }
    }
}

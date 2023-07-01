package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ErrorDialog
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.ViewModels

@Composable
fun MaterialScreen(
    modifier: Modifier = Modifier,
    materialViewModel: MaterialViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        materialViewModel.fetchMaterials()
    }

    Column(modifier = modifier.padding(8.dp)) {
        ErrorDialog(
            title = "Material Error",
            message = materialViewModel.uiState.errorMessage
        ) {
            materialViewModel.clearErrors()
        }

        MaterialList(
            materials = materialViewModel.uiState.materials,
            onUpdate = { mat, count ->
                mat.amount = count
                materialViewModel.updateMaterialCount(mat, count)
            }
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialScreenPreview() {
    val materialViewModel = ViewModels.getMaterialViewModel()

    MHWBoardGameInventoryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MaterialScreen(
                materialViewModel = materialViewModel
            )
        }
    }
}

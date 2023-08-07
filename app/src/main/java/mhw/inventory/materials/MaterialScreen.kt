package mhw.inventory.materials

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ErrorDialog
import mhw.inventory.R
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
        materialViewModel.uiState.errorMessage?.let {
            ErrorDialog(
                title = stringResource(R.string.material_error_title),
                message = it
            ) {
                materialViewModel.clearErrors()
            }
        }

        if (materialViewModel.uiState.showAddMaterialScreen) {
            AddMaterialScreen(
                onCancel = { materialViewModel.dismissAddMaterialScreen() }
            ) {
                materialViewModel.addMaterial(it)
                materialViewModel.dismissAddMaterialScreen()
            }
        }

        materialViewModel.uiState.materialToDelete?.let { material ->
            DeleteMaterialScreen(
                material = material,
                onCancel = { materialViewModel.dismissDeleteMaterialScreen() }
            ) {
                materialViewModel.deleteMaterial(it)
                materialViewModel.dismissDeleteMaterialScreen()
            }
        }

        MaterialList(
            materials = materialViewModel.uiState.materials,
            onUpdate = { mat, count ->
                materialViewModel.updateMaterialCount(mat, count)
            },
            onLongPress = { materialViewModel.showDeleteMaterialScreen(it) }
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

package mhw.inventory.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ProfileViewModel
import mhw.inventory.materials.MaterialViewModel
import mhw.inventory.materials.MaterialViewModelFactory

object ViewModels {
    @Composable
    fun getMaterialViewModel(): MaterialViewModel {
        return viewModel(
            LocalViewModelStoreOwner.current as ViewModelStoreOwner,
            "MaterialViewModel",
            MaterialViewModelFactory(LocalContext.current.applicationContext)
        )
    }

    @Composable
    fun getProfileViewModel(): ProfileViewModel {
        return viewModel()
    }
}

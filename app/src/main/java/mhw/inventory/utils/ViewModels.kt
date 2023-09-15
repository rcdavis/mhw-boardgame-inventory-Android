package mhw.inventory.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.equipment.EquipmentViewModel
import mhw.inventory.equipment.EquipmentViewModelFactory
import mhw.inventory.materials.MaterialViewModel
import mhw.inventory.materials.MaterialViewModelFactory
import mhw.inventory.materials.ProfileViewModelFactory
import mhw.inventory.profile.ProfileViewModel

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
    fun getEquipmentViewModel(): EquipmentViewModel {
        return viewModel(
            LocalViewModelStoreOwner.current as ViewModelStoreOwner,
            "EquipmentViewModel",
            EquipmentViewModelFactory(LocalContext.current.applicationContext)
        )
    }

    @Composable
    fun getProfileViewModel(): ProfileViewModel {
        return viewModel(
            LocalViewModelStoreOwner.current as ViewModelStoreOwner,
            "ProfileViewModel",
            ProfileViewModelFactory(LocalContext.current.applicationContext)
        )
    }
}

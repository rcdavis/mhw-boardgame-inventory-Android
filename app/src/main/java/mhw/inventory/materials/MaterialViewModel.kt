package mhw.inventory.materials

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import mhw.inventory.getInitialMaterials

class MaterialViewModel(
    private val repository: MaterialRepository
) : ViewModel() {
    var uiState by mutableStateOf(MaterialScreenUiState())
        private set

    fun fetchMaterials() {
        viewModelScope.launch {
            if (repository.getMaterialCount() == 0)
                repository.clearAndResetMaterials(getInitialMaterials())

            repository.materials
                .catch {
                    Log.e("MHW", it.toString())
                    uiState = uiState.copy(errorMessage = it.localizedMessage)
                }
                .collect {
                    uiState = uiState.copy(materials = it)
                }
        }
    }

    fun clearAndResetMaterials() {
        viewModelScope.launch {
            try {
                repository.clearAndResetMaterials(getInitialMaterials())
            } catch(e: Exception) {
                Log.e("MHW", "Failed to reset materials: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun testAddingMaterial() {
        addMaterial(Material(
            id = 1001,
            name = "Greatest Jagras Hide",
            amount = 1
        ))
    }

    fun addMaterial(material: Material) {
        viewModelScope.launch {
            try {
                repository.addMaterial(material)
            } catch(e: Exception) {
                Log.e("MHW", "Failed to add material ${material.name}: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun updateMaterialCount(material: Material, count: Int) {
        viewModelScope.launch {
            try {
                repository.updateMaterial(material, count)
            } catch(e: Exception) {
                Log.e("MHW", "Failed to update material ${material.name}: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun deleteAllMaterials() {
        viewModelScope.launch {
            try {
                repository.deleteAllMaterials()
            } catch(e: Exception) {
                Log.e("MHW", "Failed to delete materials: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun clearErrors() {
        uiState = uiState.copy(errorMessage = null)
    }
}

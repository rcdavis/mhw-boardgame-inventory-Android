package mhw.inventory.materials

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MaterialViewModel(
    private val repository: MaterialRepository
) : ViewModel() {
    var uiState by mutableStateOf(MaterialScreenUiState())
        private set

    fun fetchMaterials() {
        viewModelScope.launch {
            repository.getAllMaterials()
                .catch {
                    Log.e("MHW", it.toString())
                    uiState = uiState.copy(errorMessage = it.localizedMessage)
                }
                .collect {
                    uiState = uiState.copy(materials = it)
                }
        }
    }

    fun updateMaterialCount(material: Material, count: Int) {
        viewModelScope.launch {
            repository.updateMaterial(material, count)
        }
    }

    fun clearErrors() {
        uiState = uiState.copy(errorMessage = null)
    }
}

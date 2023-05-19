package mhw.inventory.materials

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MaterialViewModel(
    private val repository: MaterialRepository
) : ViewModel() {
    var materials by mutableStateOf(listOf<Material>())
        private set

    fun fetchMaterials() {
        viewModelScope.launch {
            materials = repository.getAllMaterials()
        }
    }

    fun updateMaterial(material: Material) {
        viewModelScope.launch {
            repository.updateMaterial(material)
        }
    }
}

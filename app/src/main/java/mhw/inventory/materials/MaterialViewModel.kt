package mhw.inventory.materials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import mhw.inventory.getInitialMaterials

class MaterialViewModel(
    private val repository: MaterialRepository
) : ViewModel() {
    private val _materials = MutableStateFlow(getInitialMaterials())
    val materials = _materials.asStateFlow()

    fun fetchMaterials() {
        viewModelScope.launch {
            repository.getAllMaterials().collect {
                _materials.value = it
            }
        }
    }

    fun updateMaterial(material: Material) {
        viewModelScope.launch {
            repository.updateMaterial(material)
        }
    }
}

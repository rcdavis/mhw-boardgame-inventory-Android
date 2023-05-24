package mhw.inventory.materials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MaterialViewModel(
    private val repository: MaterialRepository
) : ViewModel() {
    //private var _materials = MutableStateFlow(emptyList<Material>())
    val materials: StateFlow<List<Material>>
        get() = repository.getAllMaterials()

    fun fetchMaterials() {
        //_materials.value = repository.getAllMaterials().value
    }

    fun updateMaterial(material: Material) {
        viewModelScope.launch {
            repository.updateMaterial(material)
        }
    }
}

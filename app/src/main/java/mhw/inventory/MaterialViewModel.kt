package mhw.inventory

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class MaterialViewModel(
    //private val repository: MaterialRepository
) : ViewModel() {
    //private var _materials = mutableListOf<Material>()
    private var _materials = getMockMaterials().toMutableList()
    val materials: List<Material>
        get() = _materials

    fun addMaterial(material: Material) {
        _materials.add(material)
    }

    fun removeMaterial(material: Material) {
        _materials.remove(material)
    }

    /*fun getAllMaterials(): Flow<List<Material>> {
        return repository.getAllMaterials()
    }*/
}

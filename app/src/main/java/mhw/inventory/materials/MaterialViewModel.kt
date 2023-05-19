package mhw.inventory.materials

import androidx.lifecycle.ViewModel
import mhw.inventory.getInitialMaterials

class MaterialViewModel(
    //private val repository: MaterialRepository
) : ViewModel() {
    //private var _materials = getMockMaterials().toMutableList()
    private var _materials = getInitialMaterials().toMutableList()

    val materials: List<Material>
        get() = _materials

    fun addMaterial(material: Material) {
        _materials.add(material)
    }

    fun removeMaterial(material: Material) {
        _materials.remove(material)
    }
}

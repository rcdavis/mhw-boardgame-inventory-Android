package mhw.inventory

import androidx.lifecycle.ViewModel

class MaterialViewModel : ViewModel() {
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
}

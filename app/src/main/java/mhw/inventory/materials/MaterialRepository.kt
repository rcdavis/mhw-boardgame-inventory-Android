package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mhw.inventory.getInitialMaterials

class MaterialRepository {
    private var _materials = getInitialMaterials().toMutableList()

    suspend fun getAllMaterials(): List<Material> {
        return withContext(Dispatchers.IO) {
            Log.d("MHW", "Fetched materials from repo")
            return@withContext _materials
        }
    }

    suspend fun updateMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            val index = _materials.indexOf(material)
            if (index != -1) {
                _materials[index] = material
                Log.d("MHW", "Updated material ${material.name} in repo")
            }
        }
    }
}

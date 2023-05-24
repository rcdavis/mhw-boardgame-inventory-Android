package mhw.inventory.materials

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import mhw.inventory.db.MaterialDao
import mhw.inventory.getInitialMaterials

class MaterialRepository(
    //private val dao: MaterialDao
) {
    private var _materials = MutableStateFlow(getInitialMaterials())

    fun getAllMaterials(): StateFlow<List<Material>> {
        Log.d("MHW", "Fetched materials from repo")
        return _materials
    }

    suspend fun updateMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            val index = _materials.value.indexOf(material)
            if (index != -1) {
                //_materials.value[index] = material
                Log.d("MHW", "Updated material in repo: ${material.name} amount=${material.amount}")
            }
        }
    }
}

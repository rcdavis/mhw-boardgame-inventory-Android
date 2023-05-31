package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import mhw.inventory.db.MaterialDao
import mhw.inventory.getInitialMaterials

class MaterialRepository(
    private val dao: MaterialDao
) {
    private val _materials = MutableStateFlow(getInitialMaterials())
    val materials =  _materials.asStateFlow()

    fun getAllMaterials(): Flow<List<Material>> {
        return dao.getAllMaterials()
            .map { entry ->
                if (entry.isEmpty()) {
                    Log.d("MHW", "Creating materials and inserting into DB")
                    val mats = getInitialMaterials()
                    dao.insertAll(mats.map { MaterialDBEntry.fromMaterial(it) })
                    return@map mats
                }

                Log.d("MHW", "Returning materials from DB")
                return@map entry.map { Material.fromMaterialDBEntry(it) }
            }
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

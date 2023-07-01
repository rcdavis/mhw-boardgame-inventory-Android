package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mhw.inventory.utils.addIfNotExist

class MaterialRepository(
    private val localDataSource: MaterialLocalDataSource
) {
    private var _materials = mutableListOf<Material>()
    val materials: Flow<List<Material>>
        get() = localDataSource.getAllMaterials()

    suspend fun addMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            if (_materials.addIfNotExist(material) { it.id == material.id }) {
                localDataSource.insertMaterial(material)
                Log.d("MHW", "Inserting material into repo: ${material.name}")
            }
        }
    }

    suspend fun clearAndResetMaterials(materials: List<Material>) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteAll()
            localDataSource.insertAll(materials)
            Log.d("MHW", "Updated materials")
        }
    }

    suspend fun updateMaterial(material: Material, count: Int) {
        withContext(Dispatchers.IO) {
            localDataSource.insertMaterial(material.copy(amount = count))
            Log.d("MHW", "Updated material in repo: ${material.name} amount=${count}")
        }
    }

    suspend fun deleteAllMaterials() {
        withContext(Dispatchers.IO) {
            localDataSource.deleteAll()
            Log.d("MHW", "Deleting all materials in repo")
        }
    }

    suspend fun getMaterialCount(): Int {
        return withContext(Dispatchers.IO) {
            return@withContext localDataSource.getMaterialCount()
        }
    }
}

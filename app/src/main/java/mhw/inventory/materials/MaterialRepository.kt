package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import mhw.inventory.getInitialMaterials

class MaterialRepository(
    private val localDataSource: MaterialLocalDataSource
) {
    private var _materials = mutableListOf<Material>()

    fun getAllMaterials(): Flow<List<Material>> = flow {
        if (_materials.isEmpty()) {
            val localMats = localDataSource.getAllMaterials()
            _materials = if (localMats.isNotEmpty()) {
                localMats.toMutableList()
            } else {
                getInitialMaterials().toMutableList()
            }

            localDataSource.insertAll(_materials)
        }

        emit(_materials)
    }

    suspend fun updateMaterial(material: Material, count: Int) {
        withContext(Dispatchers.IO) {
            material.amount = count
            localDataSource.insertMaterial(material)
            Log.d("MHW", "Updated material in repo: ${material.name} amount=${count}")
        }
    }

    suspend fun deleteAllMaterials() {
        withContext(Dispatchers.IO) {
            localDataSource.deleteAll()
        }
    }
}

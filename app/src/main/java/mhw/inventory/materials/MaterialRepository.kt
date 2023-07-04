package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import mhw.inventory.utils.addIfNotExist

class MaterialRepository(
    private val localDataSource: MaterialLocalDataSource
) {
    private var _materials = mutableListOf<Material>()
    val materials: Flow<List<Material>>
        get() = localDataSource.getAllMaterials()
            .onEach { _materials = it.toMutableList() }

    suspend fun addMaterial(name: String) {
        withContext(Dispatchers.IO) {
            Log.d("MHW", "addMaterial name = $name")
            if (_materials.firstOrNull { it.name == name } == null) {
                _materials.lastOrNull()?.let {
                    val id = localDataSource.getMaxId()
                    localDataSource.insertMaterial(Material(
                        id = id + 1, name = name, amount = 1))
                    Log.d("MHW", "Inserting material into repo: $name")
                }
            }
        }
    }

    suspend fun addMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            if (_materials.addIfNotExist(material) { it.id == material.id }) {
                localDataSource.insertMaterial(material)
                Log.d("MHW", "Inserting material into repo: ${material.name}")
            }
        }
    }

    suspend fun addAllMaterials(materials: List<Material>) {
        withContext(Dispatchers.IO) {
            localDataSource.insertAll(materials)
            Log.d("MHW", "Updated materials: $materials")
        }
    }

    suspend fun deleteMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            localDataSource.delete(material)
            Log.d("MHW", "Deleting material ${material.name}")
        }
    }

    suspend fun clearAndResetMaterials(materials: List<Material>) {
        withContext(Dispatchers.IO) {
            localDataSource.deleteAll()
            localDataSource.insertAll(materials)
            Log.d("MHW", "Cleared and Updated materials")
        }
    }

    suspend fun updateMaterial(material: Material, count: Int) {
        withContext(Dispatchers.IO) {
            localDataSource.insertMaterial(material.copy(amount = count))
            Log.d("MHW", "Updated material in repo: ${material.name} amount=${count}")
        }
    }

    suspend fun getMaterialCount(): Int {
        return withContext(Dispatchers.IO) {
            return@withContext localDataSource.getMaterialCount()
        }
    }
}

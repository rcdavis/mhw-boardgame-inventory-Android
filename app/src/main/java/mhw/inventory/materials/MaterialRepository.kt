package mhw.inventory.materials

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import mhw.inventory.getInitialMaterials

class MaterialRepository(
    private val localDataSource: MaterialLocalDataSource
) {
    private val _materials = MutableStateFlow(getInitialMaterials())
    val materials =  _materials.asStateFlow()

    fun getAllMaterials(): Flow<List<Material>> {
        return localDataSource.getAllMaterials()
    }

    suspend fun updateMaterial(material: Material, count: Int) {
        withContext(Dispatchers.IO) {
            material.amount = count
            localDataSource.insertMaterial(material)
            Log.d("MHW", "Updated material in repo: ${material.name} amount=${count}")
        }
    }
}

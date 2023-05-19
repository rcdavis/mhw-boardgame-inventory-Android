package mhw.inventory.materials

import kotlinx.coroutines.flow.Flow
import mhw.inventory.db.MaterialDao

class MaterialRepository(private val dao: MaterialDao) {
    fun getAllMaterials(): Flow<List<Material>> {
        return dao.getAllMaterials()
    }

    suspend fun insertMaterial(material: Material) {
        dao.insert(material)
    }
}
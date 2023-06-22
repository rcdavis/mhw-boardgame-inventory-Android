package mhw.inventory.materials

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mhw.inventory.db.MaterialDao

class MaterialLocalDataSource(
    private val dao: MaterialDao
) {
    fun getAllMaterials(): Flow<List<Material>> {
        return dao.getAllMaterials()
            .map { entries ->
                entries.map { Material.fromMaterialDBEntry(it) }
            }
    }

    suspend fun insertMaterial(material: Material) {
        dao.insert(MaterialDBEntry.fromMaterial(material))
    }
}

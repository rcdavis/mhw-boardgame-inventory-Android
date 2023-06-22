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

    suspend fun insertAll(materials: List<Material>) {
        dao.insertAll(materials.map { MaterialDBEntry.fromMaterial(it) })
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}

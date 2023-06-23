package mhw.inventory.materials

import mhw.inventory.db.MaterialDao

class MaterialLocalDataSource(
    private val dao: MaterialDao
) {
    suspend fun getAllMaterials(): List<Material> {
        return dao.getAllMaterials().map {
            Material.fromMaterialDBEntry(it)
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

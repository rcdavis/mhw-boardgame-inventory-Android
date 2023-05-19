package mhw.inventory.materials

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mhw.inventory.db.MaterialDao
import mhw.inventory.getInitialMaterials

//class MaterialRepository(private val dao: MaterialDao) {
class MaterialRepository {
    private var _materials = getInitialMaterials().toMutableList()

    suspend fun getAllMaterials(): List<Material> {
        return withContext(Dispatchers.IO) {
            return@withContext _materials
        }
        //return dao.getAllMaterials()
    }

    suspend fun insertMaterial(material: Material) {
        withContext(Dispatchers.IO) {
            _materials.add(material)
        }
        //dao.insert(material)
    }
}

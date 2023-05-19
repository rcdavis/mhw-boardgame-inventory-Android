package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mhw.inventory.materials.Material

@Dao
interface MaterialDao {
    @Insert
    suspend fun insert(material: Material)

    @Query("SELECT * FROM materials ORDER BY name ASC")
    fun getAllMaterials(): Flow<List<Material>>
}

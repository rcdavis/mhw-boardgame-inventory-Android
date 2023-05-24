package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mhw.inventory.materials.MaterialDBEntry

@Dao
interface MaterialDao {
    @Insert
    suspend fun insert(material: MaterialDBEntry)

    @Query("SELECT * FROM materials ORDER BY name ASC")
    suspend fun getAllMaterials(): List<MaterialDBEntry>
}

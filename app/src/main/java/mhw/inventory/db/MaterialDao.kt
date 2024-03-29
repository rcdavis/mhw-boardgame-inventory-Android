package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mhw.inventory.materials.MaterialDBEntry

@Dao
interface MaterialDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(material: MaterialDBEntry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(materials: List<MaterialDBEntry>)

    @Delete(entity = MaterialDBEntry::class)
    suspend fun delete(material: MaterialDBEntry)

    @Query("DELETE FROM materials")
    suspend fun deleteAll()

    @Query("SELECT * FROM materials ORDER BY name ASC")
    fun getAllMaterials(): Flow<List<MaterialDBEntry>>

    @Query("SELECT COUNT(id) FROM materials")
    suspend fun getMaterialCount(): Int

    @Query("SELECT MAX(id) FROM materials")
    suspend fun getMaxId(): Int
}

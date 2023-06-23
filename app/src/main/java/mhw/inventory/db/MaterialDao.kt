package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mhw.inventory.materials.MaterialDBEntry

@Dao
interface MaterialDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(material: MaterialDBEntry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(materials: List<MaterialDBEntry>)

    @Query("DELETE FROM materials")
    suspend fun deleteAll()

    @Query("SELECT * FROM materials ORDER BY name ASC")
    suspend fun getAllMaterials(): List<MaterialDBEntry>
}

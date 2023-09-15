package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mhw.inventory.equipment.EquipmentDBEntry

@Dao
interface EquipmentDao {
    @Query("SELECT * FROM equipment WHERE type == :type LIMIT 1")
    fun getEquipment(type: Int): Flow<EquipmentDBEntry?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEquipment(equipment: EquipmentDBEntry)
}

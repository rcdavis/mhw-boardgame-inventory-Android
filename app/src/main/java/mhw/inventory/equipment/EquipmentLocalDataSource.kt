package mhw.inventory.equipment

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import mhw.inventory.db.EquipmentDao

class EquipmentLocalDataSource(private val dao: EquipmentDao) {
    fun getEquipmentList(): Flow<List<Equipment>> = flow {
        emit(getEquipment())
    }

    fun getEquipment(type: EquipmentType): Flow<Equipment?> {
        return dao.getEquipment(type.ordinal).map { dbEntry ->
            dbEntry?.let { Equipment.fromDBEntry(it) }
        }
    }

    suspend fun insertEquipment(equipment: Equipment) {
        dao.insertEquipment(EquipmentDBEntry.fromEquipment(equipment))
    }
}

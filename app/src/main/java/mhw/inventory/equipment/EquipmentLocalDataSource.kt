package mhw.inventory.equipment

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EquipmentLocalDataSource {
    fun getEquipmentList(): Flow<List<Equipment>> = flow {
        emit(getEquipment())
    }
}

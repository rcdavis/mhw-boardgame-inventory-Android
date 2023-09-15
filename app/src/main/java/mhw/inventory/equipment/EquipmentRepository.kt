package mhw.inventory.equipment

import kotlinx.coroutines.flow.Flow

class EquipmentRepository(
    private val localDataSource: EquipmentLocalDataSource
) {
    val equipment: Flow<List<Equipment>>
        get() = localDataSource.getEquipmentList()
}

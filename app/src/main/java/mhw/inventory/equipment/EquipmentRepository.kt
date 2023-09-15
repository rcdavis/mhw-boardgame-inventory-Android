package mhw.inventory.equipment

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class EquipmentRepository(
    private val localDataSource: EquipmentLocalDataSource
) {
    val equipment: Flow<List<Equipment>>
        get() = localDataSource.getEquipmentList()

    val headEquipment: Flow<Equipment?>
        get() = localDataSource.getEquipment(EquipmentType.HEAD)

    val bodyEquipment: Flow<Equipment?>
        get() = localDataSource.getEquipment(EquipmentType.BODY)

    val legsEquipment: Flow<Equipment?>
        get() = localDataSource.getEquipment(EquipmentType.LEGS)

    suspend fun insertEquipment(equipment: Equipment) {
        withContext(Dispatchers.IO) {
            localDataSource.insertEquipment(equipment)
        }
    }
}

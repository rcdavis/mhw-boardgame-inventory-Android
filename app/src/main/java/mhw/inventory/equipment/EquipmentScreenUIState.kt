package mhw.inventory.equipment

data class EquipmentScreenUIState(
    val headArmour: Equipment? = null,
    val bodyArmour: Equipment? = null,
    val legsArmour: Equipment? = null,
    val errorMessage: String? = null
)

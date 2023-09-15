package mhw.inventory.equipment

data class EquipmentScreenUIState(
    val equipmentList: List<Equipment> = listOf(),
    val headArmour: Equipment? = null,
    val bodyArmour: Equipment? = null,
    val legsArmour: Equipment? = null,
    val selectedEquipmentType: EquipmentType = EquipmentType.HEAD,
    val errorMessage: String? = null,
    val showChooseEquipmentDialog: Boolean = false
)

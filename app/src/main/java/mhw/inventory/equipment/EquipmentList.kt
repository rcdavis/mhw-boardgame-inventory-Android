package mhw.inventory.equipment

import mhw.inventory.R

fun getEquipment() = listOf(
    Equipment(
        textId = R.string.equipment_head_armour,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_body_armour,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_legs_armour,
        type = EquipmentType.LEGS
    )
)

fun getHeadEquipment() = getEquipment().filter { it.type == EquipmentType.HEAD }

fun getBodyEquipment() = getEquipment().filter { it.type == EquipmentType.BODY }

fun getLegsEquipment() = getEquipment().filter { it.type == EquipmentType.LEGS }

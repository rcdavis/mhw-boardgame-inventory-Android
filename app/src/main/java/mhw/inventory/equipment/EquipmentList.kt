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
    ),
    Equipment(
        textId = R.string.equipment_leather_headgear_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_chainmail_headgear_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_bone_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_alloy_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_jagras_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_kadachi_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_anja_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_rathalos_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_rath_soul_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_barroth_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_pukei_hood_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_jyura_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_diablos_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_diablos_nero_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        textId = R.string.equipment_leather_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_chainmail_vest_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_alloy_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_jagras_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_kadachi_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_anja_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_rathalos_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_rath_soul_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_barroth_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_pukei_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_jyura_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_diablos_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_diablos_nero_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        textId = R.string.equipment_leather_trousers_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_chainmail_trousers_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_bone_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_jagras_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_kadachi_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_anja_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_rathalos_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_rath_soul_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_barroth_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_pukei_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_diablos_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        textId = R.string.equipment_diablos_nero_greaves_name,
        type = EquipmentType.LEGS
    )
)

fun getHeadEquipment() = getEquipment().filter { it.type == EquipmentType.HEAD }

fun getBodyEquipment() = getEquipment().filter { it.type == EquipmentType.BODY }

fun getLegsEquipment() = getEquipment().filter { it.type == EquipmentType.LEGS }

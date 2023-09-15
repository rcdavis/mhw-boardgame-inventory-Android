package mhw.inventory.equipment

import mhw.inventory.R

fun getEquipment() = listOf(
    Equipment(
        id = 0,
        textId = R.string.equipment_leather_headgear_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 1,
        textId = R.string.equipment_chainmail_headgear_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 2,
        textId = R.string.equipment_bone_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 3,
        textId = R.string.equipment_alloy_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 4,
        textId = R.string.equipment_jagras_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 5,
        textId = R.string.equipment_kadachi_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 6,
        textId = R.string.equipment_anja_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 7,
        textId = R.string.equipment_rathalos_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 8,
        textId = R.string.equipment_rath_soul_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 9,
        textId = R.string.equipment_barroth_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 10,
        textId = R.string.equipment_pukei_hood_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 11,
        textId = R.string.equipment_jyura_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 12,
        textId = R.string.equipment_diablos_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 13,
        textId = R.string.equipment_diablos_nero_helm_name,
        type = EquipmentType.HEAD
    ),
    Equipment(
        id = 14,
        textId = R.string.equipment_leather_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 15,
        textId = R.string.equipment_chainmail_vest_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 16,
        textId = R.string.equipment_alloy_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 17,
        textId = R.string.equipment_jagras_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 18,
        textId = R.string.equipment_kadachi_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 19,
        textId = R.string.equipment_anja_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 20,
        textId = R.string.equipment_rathalos_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 21,
        textId = R.string.equipment_rath_soul_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 22,
        textId = R.string.equipment_barroth_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 23,
        textId = R.string.equipment_pukei_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 24,
        textId = R.string.equipment_jyura_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 25,
        textId = R.string.equipment_diablos_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 26,
        textId = R.string.equipment_diablos_nero_mail_name,
        type = EquipmentType.BODY
    ),
    Equipment(
        id = 27,
        textId = R.string.equipment_leather_trousers_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 28,
        textId = R.string.equipment_chainmail_trousers_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 29,
        textId = R.string.equipment_bone_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 30,
        textId = R.string.equipment_jagras_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 31,
        textId = R.string.equipment_kadachi_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 32,
        textId = R.string.equipment_anja_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 33,
        textId = R.string.equipment_rathalos_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 34,
        textId = R.string.equipment_rath_soul_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 35,
        textId = R.string.equipment_barroth_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 36,
        textId = R.string.equipment_pukei_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 37,
        textId = R.string.equipment_diablos_greaves_name,
        type = EquipmentType.LEGS
    ),
    Equipment(
        id = 38,
        textId = R.string.equipment_diablos_nero_greaves_name,
        type = EquipmentType.LEGS
    )
)

fun getHeadEquipment() = getEquipment().filter { it.type == EquipmentType.HEAD }

fun getBodyEquipment() = getEquipment().filter { it.type == EquipmentType.BODY }

fun getLegsEquipment() = getEquipment().filter { it.type == EquipmentType.LEGS }

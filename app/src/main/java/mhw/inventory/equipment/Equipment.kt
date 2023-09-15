package mhw.inventory.equipment

import androidx.annotation.StringRes

enum class EquipmentType {
    HEAD,
    BODY,
    LEGS
}

data class Equipment(
    val id: Int,
    @StringRes val textId: Int,
    val type: EquipmentType
)

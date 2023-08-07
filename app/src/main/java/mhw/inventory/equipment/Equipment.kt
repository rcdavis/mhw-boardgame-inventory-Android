package mhw.inventory.equipment

import androidx.annotation.StringRes

enum class EquipmentType {
    HEAD,
    BODY,
    LEGS
}

data class Equipment(
    @StringRes val textId: Int,
    val type: EquipmentType
)

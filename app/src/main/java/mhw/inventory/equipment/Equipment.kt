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
) {
    companion object {
        fun fromDBEntry(dbEntry: EquipmentDBEntry): Equipment {
            return Equipment(
                id = dbEntry.id,
                textId = dbEntry.nameId,
                type = EquipmentType.values()[dbEntry.type]
            )
        }
    }
}

package mhw.inventory.equipment

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipment")
data class EquipmentDBEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nameId: Int,
    val type: Int
) {
    companion object {
        fun fromEquipment(equipment: Equipment): EquipmentDBEntry {
            return EquipmentDBEntry(
                id = equipment.id,
                nameId = equipment.textId,
                type = equipment.type.ordinal
            )
        }
    }
}

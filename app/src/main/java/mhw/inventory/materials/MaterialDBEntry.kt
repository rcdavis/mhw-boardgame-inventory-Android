package mhw.inventory.materials

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materials")
data class MaterialDBEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val amount: Int
) {
    companion object {
        fun fromMaterial(material: Material): MaterialDBEntry {
            return MaterialDBEntry(
                name = material.name,
                amount = material.amount
            )
        }
    }
}

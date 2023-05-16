package mhw.inventory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materials")
class Material(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    initialAmount: Int = 1
) {
    var amount by mutableStateOf(initialAmount)
}

package mhw.inventory.materials

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Material(
    val name: String,
    amount: Int
) {
    var amount by mutableStateOf(amount)

    companion object {
        fun fromMaterialDBEntry(mdbe: MaterialDBEntry): Material {
            return Material(name = mdbe.name, amount = mdbe.amount)
        }
    }
}

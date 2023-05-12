package mhw.inventory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Material(
    val name: String,
    initialAmount: Int = 1
) {
    var amount by mutableStateOf(initialAmount)
}

package mhw.inventory.equipment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mhw.inventory.R

class EquipmentViewModel : ViewModel() {
    var uiState by mutableStateOf(EquipmentScreenUIState())
        private set

    fun fetchEquipment() {
        uiState = EquipmentScreenUIState(
            headArmour = Equipment(R.string.equipment_head_armour),
            bodyArmour = Equipment(R.string.equipment_body_armour),
            legsArmour = Equipment(R.string.equipment_legs_armour)
        )
    }
}

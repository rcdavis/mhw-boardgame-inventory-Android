package mhw.inventory.equipment

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EquipmentViewModel(
    private val repository: EquipmentRepository
) : ViewModel() {
    var uiState by mutableStateOf(EquipmentScreenUIState())
        private set

    fun fetchEquipment() {
        viewModelScope.launch {
            repository.equipment
                .catch {
                    Log.e("MHW", it.toString())
                    uiState = uiState.copy(errorMessage = it.localizedMessage)
                }
                .collect { equipmentList ->
                    uiState = uiState.copy(
                        equipmentList = equipmentList,
                        headArmour = equipmentList.first { it.type == EquipmentType.HEAD },
                        bodyArmour = equipmentList.first { it.type == EquipmentType.BODY },
                        legsArmour = equipmentList.first { it.type == EquipmentType.LEGS }
                    )
                }
        }
    }

    fun clearErrors() {
        uiState = uiState.copy(errorMessage = null)
    }
}

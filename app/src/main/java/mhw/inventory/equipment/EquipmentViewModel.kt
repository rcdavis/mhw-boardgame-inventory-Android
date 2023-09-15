package mhw.inventory.equipment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EquipmentViewModel(
    private val repository: EquipmentRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(EquipmentScreenUIState())
    val uiState: StateFlow<EquipmentScreenUIState> = _uiState

    fun fetchEquipment() {
        viewModelScope.launch {
            repository.equipment
                .catch {
                    Log.e("MHW", it.toString())
                    _uiState.value = _uiState.value.copy(errorMessage = it.localizedMessage)
                }
                .collect { equipmentList ->
                    _uiState.value = _uiState.value.copy(
                        equipmentList = equipmentList,
                        headArmour = equipmentList.first { it.type == EquipmentType.HEAD },
                        bodyArmour = equipmentList.first { it.type == EquipmentType.BODY },
                        legsArmour = equipmentList.first { it.type == EquipmentType.LEGS }
                    )
                }
        }
    }

    fun showEquipmentSelectDialog(equipmentType: EquipmentType) {
        _uiState.value = _uiState.value.copy(
            showChooseEquipmentDialog = true,
            selectedEquipmentType = equipmentType
        )
    }

    fun closeEquipmentSelectDialog() {
        _uiState.value = _uiState.value.copy(showChooseEquipmentDialog = false)
    }

    fun setSelectedEquipment(equipment: Equipment?) {
        when (_uiState.value.selectedEquipmentType) {
            EquipmentType.HEAD -> {
                _uiState.value = _uiState.value.copy(
                    headArmour = equipment,
                    showChooseEquipmentDialog = false
                )
            }
            EquipmentType.BODY -> {
                _uiState.value = _uiState.value.copy(
                    bodyArmour = equipment,
                    showChooseEquipmentDialog = false
                )
            }
            EquipmentType.LEGS -> {
                _uiState.value = _uiState.value.copy(
                    legsArmour = equipment,
                    showChooseEquipmentDialog = false
                )
            }
        }
    }

    fun getValidSelectEquipment(): List<Equipment> {
        return when (_uiState.value.selectedEquipmentType) {
            EquipmentType.HEAD -> _uiState.value.equipmentList.filter {
                it.type == EquipmentType.HEAD
            }
            EquipmentType.BODY -> _uiState.value.equipmentList.filter {
                it.type == EquipmentType.BODY
            }
            EquipmentType.LEGS -> _uiState.value.equipmentList.filter {
                it.type == EquipmentType.LEGS
            }
        }
    }

    fun clearErrors() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

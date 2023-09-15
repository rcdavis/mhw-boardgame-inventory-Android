package mhw.inventory.equipment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class EquipmentViewModel(
    private val repository: EquipmentRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(EquipmentScreenUIState())
    val uiState: StateFlow<EquipmentScreenUIState> = _uiState

    fun fetchEquipment() {
        viewModelScope.launch {
            combine(
                repository.equipment, repository.headEquipment,
                repository.bodyEquipment, repository.legsEquipment
            ) { equipmentList, head, body, legs ->
                EquipmentScreenUIState(
                    equipmentList = equipmentList,
                    headArmour = head,
                    bodyArmour = body,
                    legsArmour = legs
                )
            }
                .catch {
                    Log.e("MHW", it.toString())
                    it.printStackTrace()
                    _uiState.value = _uiState.value.copy(errorMessage = it.localizedMessage)
                }
                .collect {
                    _uiState.value = _uiState.value.copy(
                        equipmentList = it.equipmentList,
                        headArmour = it.headArmour,
                        bodyArmour = it.bodyArmour,
                        legsArmour = it.legsArmour
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

        equipment?.let {
            viewModelScope.launch {
                repository.insertEquipment(equipment)
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

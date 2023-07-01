package mhw.inventory.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: ProfileRepository
) : ViewModel() {
    var uiState by mutableStateOf(ProfileScreenUiState())
        private set

    fun fetchProfile() {
        viewModelScope.launch {
            repository.profile
                .catch {
                    Log.e("MHW", "Error fetching profile: $it")
                    uiState = uiState.copy(errorMessage = it.localizedMessage)
                }
                .collect {
                    uiState = uiState.copy(
                        campaignName = it.campaignName,
                        playerName = it.playerName,
                        hunterName = it.hunterName,
                        palicoName = it.palicoName
                    )
                }
        }
    }

    fun updateCampaignName(name: String) {
        viewModelScope.launch {
            try {
                repository.updateCampaignName(name)
            } catch(e: Exception) {
                Log.e("MHW", "Error updating profile name: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun updatePlayerName(name: String) {
        viewModelScope.launch {
            try {
                repository.updatePlayerName(name)
            } catch(e: Exception) {
                Log.e("MHW", "Error updating player name: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun updateHunterName(name: String) {
        viewModelScope.launch {
            try {
                repository.updateHunterName(name)
            } catch(e: Exception) {
                Log.e("MHW", "Error updating hunter name: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun updatePalicoName(name: String) {
        viewModelScope.launch {
            try {
                repository.updatePalicoName(name)
            } catch(e: Exception) {
                Log.e("MHW", "Error updating palico name: $e")
                uiState = uiState.copy(errorMessage = e.localizedMessage)
            }
        }
    }

    fun clearErrors() {
        uiState = uiState.copy(errorMessage = null)
    }
}

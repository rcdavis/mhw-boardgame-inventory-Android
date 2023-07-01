package mhw.inventory.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var uiState by mutableStateOf(ProfileScreenUiState())
        private set

    private var profile = Profile()

    fun updateCampaignName(name: String) {
        profile = profile.copy(campaignName = name)
        uiState = uiState.copy(campaignName = name)
    }

    fun updatePlayerName(name: String) {
        profile = profile.copy(playerName = name)
        uiState = uiState.copy(playerName = name)
    }

    fun updateHunterName(name: String) {
        profile = profile.copy(hunterName = name)
        uiState = uiState.copy(hunterName = name)
    }

    fun updatePalicoName(name: String) {
        profile = profile.copy(palicoName = name)
        uiState = uiState.copy(palicoName = name)
    }
}

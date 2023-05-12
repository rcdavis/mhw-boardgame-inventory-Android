package mhw.inventory

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    val profile = Profile()

    fun updateCampaignName(name: String) {
        profile.campaignName = name
    }

    fun updatePlayerName(name: String) {
        profile.playerName = name
    }

    fun updateHunterName(name: String) {
        profile.hunterName = name
    }

    fun updatePalicoName(name: String) {
        profile.palicoName = name
    }
}

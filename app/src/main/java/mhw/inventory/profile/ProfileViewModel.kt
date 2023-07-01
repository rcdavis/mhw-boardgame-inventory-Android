package mhw.inventory.profile

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

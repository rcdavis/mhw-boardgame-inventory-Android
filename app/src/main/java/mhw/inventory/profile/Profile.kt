package mhw.inventory.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Profile(
    initialCampaignName: String = "",
    initialPlayerName: String = "",
    initialHunterName: String = "",
    initialPalicoName: String = ""
) {
    var campaignName by mutableStateOf(initialCampaignName)
    var playerName by mutableStateOf(initialPlayerName)
    var hunterName by mutableStateOf(initialHunterName)
    var palicoName by mutableStateOf(initialPalicoName)
}

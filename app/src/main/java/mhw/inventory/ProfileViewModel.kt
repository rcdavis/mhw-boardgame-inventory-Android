package mhw.inventory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var campaignName by mutableStateOf("")
    var playerName by mutableStateOf("")
    var hunterName by mutableStateOf("")
    var palicoName by mutableStateOf("")
}

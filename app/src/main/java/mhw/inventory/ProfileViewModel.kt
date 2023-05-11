package mhw.inventory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private var _materials = mutableListOf<Material>()
    val materials: List<Material>
        get() = _materials

    var campaignName by mutableStateOf("")
    var playerName by mutableStateOf("")
    var hunterName by mutableStateOf("")
    var palicoName by mutableStateOf("")
}

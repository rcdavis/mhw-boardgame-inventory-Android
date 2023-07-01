package mhw.inventory.profile

data class ProfileScreenUiState(
    val campaignName: String = "",
    val playerName: String = "",
    val hunterName: String = "",
    val palicoName: String = "",
    val errorMessage: String? = null,
)

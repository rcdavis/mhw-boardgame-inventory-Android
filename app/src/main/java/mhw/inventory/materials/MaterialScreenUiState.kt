package mhw.inventory.materials

data class MaterialScreenUiState(
    val materials: List<Material> = listOf(),
    val errorMessage: String? = null
)

package mhw.inventory.materials

data class MaterialScreenUiState(
    val materials: List<Material> = listOf(),
    val materialToDelete: Material? = null,
    val errorMessage: String? = null,
    val showAddMaterialScreen: Boolean = false
)

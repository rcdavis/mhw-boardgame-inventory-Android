package mhw.inventory.materials

data class Material(
    val id: Int,
    val name: String,
    val amount: Int
) {
    companion object {
        fun fromMaterialDBEntry(mdbe: MaterialDBEntry): Material {
            return Material(id = mdbe.id, name = mdbe.name, amount = mdbe.amount)
        }
    }
}

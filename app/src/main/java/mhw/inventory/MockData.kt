package mhw.inventory

fun getMockMaterials() = listOf(
    Material(name = "Ancient Bone", initialAmount = 2),
    Material(name = "Boulder Bone", initialAmount = 4),
    Material(name = "Carbalite Ore", initialAmount = 2),
    Material(name = "Dragonite Ore", initialAmount = 4),
    Material(name = "Dragonvein Crystal", initialAmount = 7),
    Material(name = "Fucium Ore", initialAmount = 0),
    Material(name = "Malachite Ore", initialAmount = 1),
    Material(name = "Monster Bone Large", initialAmount = 6),
    Material(name = "Monster Bone Medium", initialAmount = 12),
    Material(name = "Monster Bone Small", initialAmount = 19),
    Material(name = "Monster Hardbone", initialAmount = 0),
    Material(name = "Monster Keenbone", initialAmount = 4),
    Material(name = "Quality Bone", initialAmount = 3),
    Material(name = "Wingdrake Hide", initialAmount = 4)
).sortedBy { it.name }

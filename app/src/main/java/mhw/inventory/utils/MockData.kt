package mhw.inventory.utils

import mhw.inventory.materials.Material

fun getMockMaterials() = listOf(
    Material(id = 1, name = "Ancient Bone", amount = 2),
    Material(id = 2, name = "Boulder Bone", amount = 4),
    Material(id = 3, name = "Carbalite Ore", amount = 2),
    Material(id = 4, name = "Dragonite Ore", amount = 4),
    Material(id = 5, name = "Dragonvein Crystal", amount = 7),
    Material(id = 6, name = "Fucium Ore", amount = 0),
    Material(id = 7, name = "Malachite Ore", amount = 1),
    Material(id = 8, name = "Monster Bone Large", amount = 6),
    Material(id = 9, name = "Monster Bone Medium", amount = 12),
    Material(id = 10, name = "Monster Bone Small", amount = 19),
    Material(id = 11, name = "Monster Hardbone", amount = 0),
    Material(id = 12, name = "Monster Keenbone", amount = 4),
    Material(id = 13, name = "Quality Bone", amount = 3),
    Material(id = 14, name = "Wingdrake Hide", amount = 4)
)

fun getInitialMaterials() = listOf(
    Material(id = 1, name = "Ancient Bone", amount = 0),
    Material(id = 2, name = "Boulder Bone", amount = 0),
    Material(id = 3, name = "Carbalite Ore", amount = 0),
    Material(id = 4, name = "Dragonite Ore", amount = 0),
    Material(id = 5, name = "Dragonvein Crystal", amount = 0),
    Material(id = 6, name = "Fucium Ore", amount = 0),
    Material(id = 7, name = "Malachite Ore", amount = 0),
    Material(id = 8, name = "Monster Bone Large", amount = 0),
    Material(id = 9, name = "Monster Bone Medium", amount = 0),
    Material(id = 10, name = "Monster Bone Small", amount = 0),
    Material(id = 11, name = "Monster Hardbone", amount = 0),
    Material(id = 12, name = "Monster Keenbone", amount = 0),
    Material(id = 13, name = "Quality Bone", amount = 0),
    Material(id = 14, name = "Wingdrake Hide", amount = 0)
)

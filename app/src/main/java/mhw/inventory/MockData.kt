package mhw.inventory

import mhw.inventory.materials.Material

fun getMockMaterials() = listOf(
    Material(name = "Ancient Bone", amount = 2),
    Material(name = "Boulder Bone", amount = 4),
    Material(name = "Carbalite Ore", amount = 2),
    Material(name = "Dragonite Ore", amount = 4),
    Material(name = "Dragonvein Crystal", amount = 7),
    Material(name = "Fucium Ore", amount = 0),
    Material(name = "Malachite Ore", amount = 1),
    Material(name = "Monster Bone Large", amount = 6),
    Material(name = "Monster Bone Medium", amount = 12),
    Material(name = "Monster Bone Small", amount = 19),
    Material(name = "Monster Hardbone", amount = 0),
    Material(name = "Monster Keenbone", amount = 4),
    Material(name = "Quality Bone", amount = 3),
    Material(name = "Wingdrake Hide", amount = 4)
)

fun getInitialMaterials() = listOf(
    Material(name = "Ancient Bone", amount = 0),
    Material(name = "Boulder Bone", amount = 0),
    Material(name = "Carbalite Ore", amount = 0),
    Material(name = "Dragonite Ore", amount = 0),
    Material(name = "Dragonvein Crystal", amount = 0),
    Material(name = "Fucium Ore", amount = 0),
    Material(name = "Malachite Ore", amount = 0),
    Material(name = "Monster Bone Large", amount = 0),
    Material(name = "Monster Bone Medium", amount = 0),
    Material(name = "Monster Bone Small", amount = 0),
    Material(name = "Monster Hardbone", amount = 0),
    Material(name = "Monster Keenbone", amount = 0),
    Material(name = "Quality Bone", amount = 0),
    Material(name = "Wingdrake Hide", amount = 0)
)

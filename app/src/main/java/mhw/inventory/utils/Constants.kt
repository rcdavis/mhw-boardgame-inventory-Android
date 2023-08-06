package mhw.inventory.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import mhw.inventory.BottonNavItem
import mhw.inventory.R

object Constants {
    val BottomNavItems = listOf(
        BottonNavItem(
            labelId = R.string.materials_title,
            icon = Icons.Default.List,
            route = Keys.materialScreen
        ),
        BottonNavItem(
            labelId = R.string.equipment_title,
            icon = Icons.Default.MoreVert,
            route = Keys.equipmentScreen
        ),
        BottonNavItem(
            labelId = R.string.profile_title,
            icon = Icons.Default.AccountCircle,
            route = Keys.profileScreen
        )
    )
}

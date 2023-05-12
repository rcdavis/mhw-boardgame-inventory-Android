package mhw.inventory.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import mhw.inventory.BottonNavItem
import mhw.inventory.R

object Constants {
    val BottomNavItems = listOf(
        BottonNavItem(
            labelId = R.string.materials_title,
            icon = Icons.Default.List,
            route = "materials"
        ),
        BottonNavItem(
            labelId = R.string.profile_title,
            icon = Icons.Default.AccountCircle,
            route = "profile"
        )
    )
}

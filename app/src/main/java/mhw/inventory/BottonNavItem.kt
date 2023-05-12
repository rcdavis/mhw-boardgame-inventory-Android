package mhw.inventory

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottonNavItem(
    @StringRes val labelId: Int,
    val icon: ImageVector,
    val route: String
)

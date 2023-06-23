package mhw.inventory

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import mhw.inventory.utils.Keys

@Composable
fun TopBar(
    navController: NavHostController,
    onMaterialRefresh: () -> Unit,
    onMaterialDeleted: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val curRoute = navBackStackEntry?.destination?.route
    val titleText = when (curRoute) {
        Keys.materialScreen -> stringResource(R.string.materials_title)
        Keys.profileScreen -> stringResource(R.string.profile_title)
        else -> ""
    }

    TopAppBar(
        title = { Text(titleText) },
        actions = {
            if (curRoute == Keys.materialScreen) {
                TopAppBarActionButton(
                    imageVector = Icons.Filled.Refresh,
                    onClick = onMaterialRefresh
                )
                TopAppBarActionButton(
                    imageVector = Icons.Filled.Delete,
                    onClick = onMaterialDeleted
                )
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}

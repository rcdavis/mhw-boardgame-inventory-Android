package mhw.inventory

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
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
    onMaterialAdd: () -> Unit,
    onMaterialReset: () -> Unit
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
                    imageVector = Icons.Filled.Add,
                    onClick = onMaterialAdd
                )
                TopAppBarActionButton(
                    imageVector = Icons.Filled.Clear,
                    onClick = onMaterialReset
                )
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(imageVector = imageVector, contentDescription = contentDescription)
    }
}

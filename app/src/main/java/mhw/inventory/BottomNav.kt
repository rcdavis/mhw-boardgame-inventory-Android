package mhw.inventory

import android.content.res.Configuration
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.Constants

@Composable
fun BottomNav(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val curRoute = navBackStackEntry?.destination?.route

        Constants.BottomNavItems.forEach { navItem ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(navItem.labelId)
                    )
                },
                selected = curRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                }
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomNavPreview() {
    MHWBoardGameInventoryTheme {
        val navController = rememberNavController()

        Surface {
            BottomNav(navController = navController)
        }
    }
}

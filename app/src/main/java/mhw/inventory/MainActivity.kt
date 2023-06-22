package mhw.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mhw.inventory.materials.MaterialScreen
import mhw.inventory.materials.MaterialViewModel
import mhw.inventory.materials.MaterialViewModelFactory
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.Keys

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MHWBoardGameInventoryTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Scaffold(
                        bottomBar = { BottomNav(navController = navController) }
                    ) { paddingValues ->
                        NavHostContainer(
                            navController = navController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Keys.materialScreen,
        modifier = Modifier.padding(paddingValues),
        builder = {
            composable(Keys.materialScreen) {
                MaterialScreen(materialViewModel = viewModel(
                    LocalViewModelStoreOwner.current as ViewModelStoreOwner,
                    "MaterialViewModel",
                    MaterialViewModelFactory(LocalContext.current.applicationContext)
                ))
            }
            composable(Keys.profileScreen) {
                ProfileScreen(profileViewModel = viewModel())
            }
        }
    )
}

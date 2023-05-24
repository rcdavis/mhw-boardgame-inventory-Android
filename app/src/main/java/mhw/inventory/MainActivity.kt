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
    LocalViewModelStoreOwner.current?.let {
        val materialViewModel: MaterialViewModel = viewModel(
            it,
            "MaterialViewModel",
            MaterialViewModelFactory(LocalContext.current.applicationContext)
        )
        val profileViewModel: ProfileViewModel = viewModel()

        NavHost(
            navController = navController,
            startDestination = "materials",
            modifier = Modifier.padding(paddingValues),
            builder = {
                composable("materials") {
                    MaterialScreen(materialViewModel = materialViewModel)
                }
                composable("profile") {
                    ProfileScreen(profileViewModel = profileViewModel)
                }
            }
        )
    }
}

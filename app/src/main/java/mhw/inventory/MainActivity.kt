package mhw.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mhw.inventory.equipment.EquipmentScreen
import mhw.inventory.materials.MaterialScreen
import mhw.inventory.profile.ProfileScreen
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.Keys
import mhw.inventory.utils.ViewModels

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
                    val materialViewModel = ViewModels.getMaterialViewModel()
                    val equipmentViewModel = ViewModels.getEquipmentViewModel()
                    val profileViewModel = ViewModels.getProfileViewModel()

                    Scaffold(
                        topBar = {
                            TopBar(
                                navController = navController,
                                onMaterialAdd = { materialViewModel.showAddMaterialScreen() },
                                onMaterialReset = { materialViewModel.clearAndResetMaterials() }
                            )
                        },
                        bottomBar = {
                            BottomNav(navController = navController)
                        }
                    ) { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = Keys.materialScreen,
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            composable(Keys.materialScreen) {
                                MaterialScreen(materialViewModel = materialViewModel)
                            }
                            composable(Keys.equipmentScreen) {
                                EquipmentScreen(equipmentViewModel = equipmentViewModel)
                            }
                            composable(Keys.profileScreen) {
                                ProfileScreen(profileViewModel = profileViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}

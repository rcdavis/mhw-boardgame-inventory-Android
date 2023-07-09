package mhw.inventory.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ErrorDialog
import mhw.inventory.R
import mhw.inventory.TextInputField
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        profileViewModel.fetchProfile()
    }

    Column(modifier = modifier.padding(8.dp)) {
        profileViewModel.uiState.errorMessage?.let {
            ErrorDialog(
                title = "Profile Error",
                message = it
            ) {
                profileViewModel.clearErrors()
            }
        }

        TextInputField(
            labelTextId = R.string.campaign_name,
            valueText = profileViewModel.uiState.campaignName
        ) {
            profileViewModel.updateCampaignName(it)
        }

        TextInputField(
            labelTextId = R.string.player_name,
            valueText = profileViewModel.uiState.playerName
        ) {
            profileViewModel.updatePlayerName(it)
        }

        TextInputField(
            labelTextId = R.string.hunter_name,
            valueText = profileViewModel.uiState.hunterName
        ) {
            profileViewModel.updateHunterName(it)
        }

        TextInputField(
            labelTextId = R.string.palico_name,
            valueText = profileViewModel.uiState.palicoName
        ) {
            profileViewModel.updatePalicoName(it)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenPreview() {
    MHWBoardGameInventoryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProfileScreen()
        }
    }
}

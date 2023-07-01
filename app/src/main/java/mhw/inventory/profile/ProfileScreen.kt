package mhw.inventory.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ErrorDialog
import mhw.inventory.R
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        profileViewModel.fetchProfile()
    }

    Column(modifier = modifier.padding(8.dp)) {
        ErrorDialog(
            title = "Profile Error",
            message = profileViewModel.uiState.errorMessage
        ) {
            profileViewModel.clearErrors()
        }

        TextField(
            value = profileViewModel.uiState.campaignName,
            onValueChange = { profileViewModel.updateCampaignName(it) },
            label = {
                Text(stringResource(R.string.campaign_name))
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = profileViewModel.uiState.playerName,
            onValueChange = { profileViewModel.updatePlayerName(it) },
            label = {
                Text(stringResource(R.string.player_name))
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = profileViewModel.uiState.hunterName,
            onValueChange = { profileViewModel.updateHunterName(it) },
            label = {
                Text(stringResource(R.string.hunter_name))
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        TextField(
            value = profileViewModel.uiState.palicoName,
            onValueChange = { profileViewModel.updatePalicoName(it) },
            label = {
                Text(stringResource(R.string.palico_name))
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
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

package mhw.inventory

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        TextInput(labelId = R.string.campaign_name, onValueChange = {})
        TextInput(labelId = R.string.player_name, onValueChange = {})
        TextInput(labelId = R.string.hunter_name, onValueChange = {})
        TextInput(labelId = R.string.palico_name, onValueChange = {})
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

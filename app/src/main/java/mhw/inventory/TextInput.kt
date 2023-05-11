package mhw.inventory

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    @StringRes labelId: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(
                text = stringResource(labelId),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            TextField(
                value = text,
                onValueChange = { onValueChange(it) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextInputBlankPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            TextInput(labelId = R.string.player_name, onValueChange = {})
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextInputFilledPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            TextInput(
                labelId = R.string.player_name,
                text = "Random Hunter",
                onValueChange = {}
            )
        }
    }
}

package mhw.inventory

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(
    labelText: String,
    valueText: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = valueText,
        onValueChange = onValueChange,
        label = { Text(labelText) },
        modifier = modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun TextInputField(
    @StringRes labelTextId: Int,
    valueText: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    TextInputField(
        labelText = stringResource(labelTextId),
        valueText = valueText,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextInputFieldPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            TextInputField(
                labelText = "Label Text",
                valueText = "Value",
                onValueChange = {}
            )
        }
    }
}

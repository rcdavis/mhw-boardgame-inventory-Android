package mhw.inventory

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun InventoryListItem(
    text: String,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(start = 8.dp)) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = count.toString(),
            modifier = Modifier
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically)
        )
        IconButton(
            onClick = { onCountChange(count + 1) }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }
        IconButton(
            onClick = { onCountChange(count - 1) },
            enabled = count > 0
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}

@Composable
fun InventoryListItem(
    @StringRes textId: Int,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    InventoryListItem(
        text = stringResource(textId),
        count = count,
        onCountChange = onCountChange,
        modifier = modifier
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialListItemPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            InventoryListItem(
                textId = R.string.carbalite_ore,
                count = 1,
                onCountChange = {}
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialListItemEmptyPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            InventoryListItem(
                textId = R.string.malachite_ore,
                count = 0,
                onCountChange = {}
            )
        }
    }
}

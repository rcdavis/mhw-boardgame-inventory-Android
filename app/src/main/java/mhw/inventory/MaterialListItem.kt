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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun MaterialListItem(
    text: String,
    count: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    var countState by remember { mutableStateOf(count) }

    Row(modifier = modifier.padding(start = 8.dp)) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = countState.toString(),
            modifier = Modifier
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically)
        )
        IconButton(
            onClick = {
                ++countState
                onAdd()
            }
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }
        IconButton(
            onClick = {
                --countState
                onRemove()
            },
            enabled = countState > 0
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}

@Composable
fun MaterialListItem(
    @StringRes textId: Int,
    count: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    MaterialListItem(
        text = stringResource(textId),
        count = count,
        onAdd = onAdd,
        onRemove = onRemove,
        modifier = modifier
    )
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MaterialListItemPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            MaterialListItem(
                textId = R.string.carbalite_ore,
                count = 1,
                onAdd = {},
                onRemove = {}
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
            MaterialListItem(
                textId = R.string.malachite_ore,
                count = 0,
                onAdd = {},
                onRemove = {}
            )
        }
    }
}

package mhw.inventory.equipment

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mhw.inventory.BaseDialog
import mhw.inventory.R
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme

@Composable
fun EquipmentSelectDialog(
    equipmentList: List<Equipment>,
    onCancel: () -> Unit,
    onConfirm: (Equipment) -> Unit
) {
    var selectedEquipment by remember {
        mutableStateOf<Equipment?>(null)
    }

    BaseDialog(
        titleTextId = R.string.equipment_select_title,
        onConfirm = { onConfirm(selectedEquipment!!) },
        onCancel = onCancel,
        enableConfirm = selectedEquipment != null
    ) {
        LazyColumn(modifier = Modifier.heightIn(0.dp, 225.dp)) {
            items(equipmentList, key = { it.id }) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable { selectedEquipment = it }
                ) {
                    Text(
                        text = stringResource(it.textId),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview(name = "Light Mode", group = "Base")
@Preview(
    name = "Dark Mode",
    group = "Base",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun EquipmentSelectDialogPreview() {
    MHWBoardGameInventoryTheme {
        Surface {
            EquipmentSelectDialog(
                equipmentList = getHeadEquipment(),
                onConfirm = {},
                onCancel = {}
            )
        }
    }
}

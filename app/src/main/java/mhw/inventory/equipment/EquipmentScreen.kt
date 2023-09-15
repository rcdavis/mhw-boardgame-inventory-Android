package mhw.inventory.equipment

import android.content.res.Configuration
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mhw.inventory.ErrorDialog
import mhw.inventory.R
import mhw.inventory.ui.theme.MHWBoardGameInventoryTheme
import mhw.inventory.utils.ScrollingColumn
import mhw.inventory.utils.ViewModels

@Composable
fun EquipmentScreen(
    modifier: Modifier = Modifier,
    equipmentViewModel: EquipmentViewModel = viewModel()
) {
    LaunchedEffect(equipmentViewModel) {
        equipmentViewModel.fetchEquipment()
    }

    val uiState by equipmentViewModel.uiState.collectAsState()

    if (uiState.showChooseEquipmentDialog) {
        EquipmentSelectDialog(
            equipmentList = equipmentViewModel.getValidSelectEquipment(),
            onCancel = equipmentViewModel::closeEquipmentSelectDialog
        ) {
            equipmentViewModel.setSelectedEquipment(it)
        }
    }

    ScrollingColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        uiState.errorMessage?.let {
            ErrorDialog(
                title = stringResource(R.string.equipment_error_title),
                message = it,
                onConfirm = equipmentViewModel::clearErrors
            )
        }

        Text(
            text = stringResource(R.string.equipment_armour_title),
            style = MaterialTheme.typography.headlineLarge
        )

        EquipmentCard(
            imageId = R.drawable.helmet_icon_white,
            nameTextId = uiState.headArmour?.textId ?: R.string.equipment_head_armour
        ) {
            printMessage("Head")
            equipmentViewModel.showEquipmentSelectDialog(EquipmentType.HEAD)
        }

        EquipmentCard(
            imageId = R.drawable.chest_icon_white,
            nameTextId = uiState.bodyArmour?.textId ?: R.string.equipment_body_armour
        ) {
            printMessage("Body")
            equipmentViewModel.showEquipmentSelectDialog(EquipmentType.BODY)
        }

        EquipmentCard(
            imageId = R.drawable.leg_icon_white,
            nameTextId = uiState.legsArmour?.textId ?: R.string.equipment_legs_armour
        ) {
            printMessage("Legs")
            equipmentViewModel.showEquipmentSelectDialog(EquipmentType.LEGS)
        }
    }
}

fun printMessage(text: String) {
    Log.d("MHW", "Clicked card: $text")
}

@Composable
fun EquipmentCard(
    @DrawableRes imageId: Int,
    @StringRes nameTextId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(imageId),
                contentDescription = stringResource(nameTextId),
                modifier = Modifier.size(75.dp)
            )

            Text(
                text = stringResource(nameTextId),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EquipmentScreenPreview() {
    val equipmentViewModel = ViewModels.getEquipmentViewModel()

    MHWBoardGameInventoryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            EquipmentScreen(
                equipmentViewModel = equipmentViewModel
            )
        }
    }
}

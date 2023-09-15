package mhw.inventory.equipment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mhw.inventory.db.EquipmentDatabase

class EquipmentViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EquipmentViewModel(
            EquipmentRepository(
                EquipmentLocalDataSource(
                    EquipmentDatabase.getDatabase(context).dao()
                )
            )
        ) as T
    }
}

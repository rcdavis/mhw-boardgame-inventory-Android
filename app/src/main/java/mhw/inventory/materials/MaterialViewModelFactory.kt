package mhw.inventory.materials

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mhw.inventory.db.MaterialDatabase

class MaterialViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MaterialViewModel(MaterialRepository(
            //MaterialDatabase.getDatabase(context).dao()
        )) as T
    }
}

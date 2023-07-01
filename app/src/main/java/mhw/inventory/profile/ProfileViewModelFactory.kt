package mhw.inventory.materials

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mhw.inventory.db.ProfileDatabase
import mhw.inventory.profile.ProfileLocalDataSource
import mhw.inventory.profile.ProfileRepository
import mhw.inventory.profile.ProfileViewModel

class ProfileViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(ProfileRepository(
            ProfileLocalDataSource(
                ProfileDatabase.getDatabase(context).dao()
            )
        )
        ) as T
    }
}

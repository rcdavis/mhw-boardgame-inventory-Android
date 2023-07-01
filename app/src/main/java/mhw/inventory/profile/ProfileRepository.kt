package mhw.inventory.profile

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class ProfileRepository(
    private val localDataSource: ProfileLocalDataSource
) {
    private var _profile = Profile()
    val profile: Flow<Profile>
        get() = localDataSource.getProfile()
            .onEach { _profile = it }

    suspend fun updateCampaignName(name: String) {
        withContext(Dispatchers.IO) {
            localDataSource.insertProfile(_profile.copy(campaignName = name))
            Log.d("MHW", "Updating profile campaign name: $name")
        }
    }

    suspend fun updatePlayerName(name: String) {
        withContext(Dispatchers.IO) {
            localDataSource.insertProfile(_profile.copy(playerName = name))
            Log.d("MHW", "Updating profile player name: $name")
        }
    }

    suspend fun updateHunterName(name: String) {
        withContext(Dispatchers.IO) {
            localDataSource.insertProfile(_profile.copy(hunterName = name))
            Log.d("MHW", "Updating profile hunter name: $name")
        }
    }

    suspend fun updatePalicoName(name: String) {
        withContext(Dispatchers.IO) {
            localDataSource.insertProfile(_profile.copy(palicoName = name))
            Log.d("MHW", "Updating profile palico name: $name")
        }
    }
}

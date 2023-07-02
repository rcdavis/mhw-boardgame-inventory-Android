package mhw.inventory.profile

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mhw.inventory.db.ProfileDao

class ProfileLocalDataSource(
    private val dao: ProfileDao
) {
    fun getProfile(): Flow<Profile> {
        return dao.getProfile().map { Profile.fromProfileDBEntry(it) }
    }

    suspend fun insertProfile(profile: Profile) {
        return dao.insert(ProfileDBEntry.fromProfile(profile))
    }

    suspend fun getProfileCount() = dao.getProfileCount()
}

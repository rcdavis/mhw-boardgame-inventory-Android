package mhw.inventory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import mhw.inventory.profile.ProfileDBEntry

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: ProfileDBEntry)

    @Query("SELECT * FROM profiles")
    fun getProfile(): Flow<ProfileDBEntry>
}

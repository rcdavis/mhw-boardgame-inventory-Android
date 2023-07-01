package mhw.inventory.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mhw.inventory.profile.ProfileDBEntry

@Database(entities = [ProfileDBEntry::class], version = 1, exportSchema = false)
abstract class ProfileDatabase: RoomDatabase() {
    abstract fun dao(): ProfileDao

    companion object {
        @Volatile
        private var Instance: ProfileDatabase? = null

        fun getDatabase(context: Context): ProfileDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    ProfileDatabase::class.java,
                    "profile_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

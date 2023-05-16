package mhw.inventory.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mhw.inventory.Material

@Database(entities = [Material::class], version = 1, exportSchema = false)
abstract class MaterialDatabase: RoomDatabase() {
    abstract fun dao(): MaterialDao

    companion object {
        @Volatile
        private var Instance: MaterialDatabase? = null

        fun getDatabase(context: Context): MaterialDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MaterialDatabase::class.java,
                    "material_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

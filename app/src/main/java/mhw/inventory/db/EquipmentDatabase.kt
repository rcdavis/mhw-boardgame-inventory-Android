package mhw.inventory.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mhw.inventory.equipment.EquipmentDBEntry

@Database(entities = [EquipmentDBEntry::class], version = 1, exportSchema = false)
abstract class EquipmentDatabase: RoomDatabase() {
    abstract fun dao(): EquipmentDao

    companion object {
        @Volatile
        private var Instance: EquipmentDatabase? = null

        fun getDatabase(context: Context): EquipmentDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    EquipmentDatabase::class.java,
                    "equipment_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}

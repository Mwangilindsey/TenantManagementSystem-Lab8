
package com.example.tenantmanagementsystem.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TenantEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TenantDatabase : RoomDatabase() {

    abstract fun tenantDao(): TenantDao

    companion object {

        @Volatile
        private var INSTANCE: TenantDatabase? = null

        fun getDatabase(context: Context): TenantDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TenantDatabase::class.java,
                    "tenant_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}

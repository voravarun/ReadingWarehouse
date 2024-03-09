package com.example.readingwarehouse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.readingwarehouse.Entites.BookToBuy

@Database(entities = [BookToBuy::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun BookToBuyDao(): BookToBuyDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "BToBuy_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
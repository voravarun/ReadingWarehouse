package com.example.readingwarehouse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.readingwarehouse.Entites.MyShelf



@Database(entities = [MyShelf::class], version = 1)
abstract class MyShelfDatabase : RoomDatabase() {

    abstract fun myShelfDao(): MyShelfDAO

    companion object {
        @Volatile
        private var INSTANCE: MyShelfDatabase? = null

        fun getDatabase(context: Context): MyShelfDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyShelfDatabase::class.java,
                    "MyShelf_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

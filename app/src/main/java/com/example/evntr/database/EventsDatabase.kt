package com.example.evntr.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Event::class], version = 1)
abstract class EventsDatabase : RoomDatabase() {
    abstract fun eventsDao(): EventsDao

    /*companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, "SmallTalk_Database"
            ).build()
        }
    } */
}
package com.andry.marvelapplication.data.room.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andry.marvelapplication.data.models.Comic
import com.andry.marvelapplication.data.room.daos.ComicDao

@Database(entities = [Comic::class], version = 8, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

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
                "app_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}
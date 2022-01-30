package com.triare.p131todolistapp.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.db.dao.CategoryDao
import com.triare.p131todolistapp.data.model.CategoryDbo

@Database(entities = [CategoryDbo::class], version = 1)
abstract class AppDatabaseCategory : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {

        private var instance: AppDatabaseCategory? = null

        fun getInstanceCategory(): AppDatabaseCategory {
            if (instance == null) {
                synchronized(AppDatabaseCategory::class.java) {
                    instance = Room.databaseBuilder(
                        App.context,
                        AppDatabaseCategory::class.java,
                        "room"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }
    }
}
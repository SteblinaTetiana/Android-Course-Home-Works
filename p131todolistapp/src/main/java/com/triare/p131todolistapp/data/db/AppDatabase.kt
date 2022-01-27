package com.triare.p131todolistapp.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.db.dao.CategoryDao
import com.triare.p131todolistapp.data.model.CategoryDbo

@Database(entities = [CategoryDbo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun  listNoteDao():CategoryDao

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(
                       App.context,
                        AppDatabase::class.java,
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
package com.triare.p131todolistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.db.dao.ListNoteDao
import com.triare.p131todolistapp.data.model.ListNoteDbo

@Database(entities = [ListNoteDbo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun  listNoteDao():ListNoteDao

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
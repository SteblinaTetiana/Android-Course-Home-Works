package com.triare.p131todolistapp.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triare.p131todolistapp.App
import com.triare.p131todolistapp.data.db.dao.TaskDao
import com.triare.p131todolistapp.data.model.TaskDbo

@Database(entities = [TaskDbo::class], version = 1)
abstract class AppDatabaseTasks : RoomDatabase() {

    abstract fun tasksDao(): TaskDao

    companion object {

        private var instance: AppDatabaseTasks? = null

        fun getInstanceTasks(): AppDatabaseTasks {
            if (instance == null) {
                synchronized(AppDatabaseTasks::class.java) {
                    instance = Room.databaseBuilder(
                        App.context,
                        AppDatabaseTasks::class.java,
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
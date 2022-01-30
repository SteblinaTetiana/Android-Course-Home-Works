package com.triare.p131todolistapp.data.repository

import androidx.lifecycle.LiveData
import com.triare.p131todolistapp.data.db.AppDatabaseTasks
import com.triare.p131todolistapp.data.model.TaskDbo

class TasksRepository {

    private val categoryId: Int? = null

    private val dbTasks = AppDatabaseTasks.getInstanceTasks()

    private val tasksDao = dbTasks.tasksDao()

   /* val allTasks: LiveData<List<TaskDbo>> = categoryId?.let { tasksDao.getTasks(it) }!!*/

    /*fun getTasks() = tasksDao.getTasks()*/

    fun addTasks(taskDbo: TaskDbo) {
        tasksDao.insert(taskDbo)
    }

    fun updateTask(id: Int, text: String) {
        tasksDao.updateTask(id, text)
    }

    fun delete(taskId: Int) {
        tasksDao.delete(taskId)
    }

    fun deleteByCategory(categoryId: Int) {
        tasksDao.deleteByCategory(categoryId)
    }
}
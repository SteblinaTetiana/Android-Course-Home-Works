package com.triare.p131todolistapp.data.repository

import androidx.lifecycle.LiveData
import com.triare.p131todolistapp.data.db.AppDatabase
import com.triare.p131todolistapp.data.model.TaskDbo
import com.triare.p131todolistapp.data.remote.TaskDataSource

class TasksRepository {

    private val dbTasks = AppDatabase.getInstance()

    private val tasksDao = dbTasks.taskDao()

    private val taskDataSource = TaskDataSource()

    val allTasks: LiveData<List<TaskDbo>> = tasksDao.getAllTasks()

    fun getTasks(categoryId: Int) {
        tasksDao.getTasks(categoryId)
    }

    fun getTasksCount(categoryId: Int) {
        tasksDao.getTasksCount(categoryId)
    }

    fun getFinishedTasksCount(categoryId: Int) {
        tasksDao.getFinishedTasksCount(categoryId)
    }

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

    fun addTask(task: TaskDbo) {
        taskDataSource.addTask(task)
    }

}
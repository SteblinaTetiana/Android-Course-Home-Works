package com.triare.p131todolistapp.ui.category_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.triare.p131todolistapp.data.model.TaskDbo
import com.triare.p131todolistapp.data.repository.TasksRepository

class CategoryDetailViewModel : ViewModel() {

    private val tasksRepository = TasksRepository()

    val allTasks: LiveData<List<TaskDbo>> = tasksRepository.allTasks

    fun getTasks(categoryId: Int) {
        tasksRepository.getTasks(categoryId)
    }

    fun getTasksCount(categoryId: Int) {
        tasksRepository.getTasksCount(categoryId)
    }

    fun getFinishedTasksCount(categoryId: Int) {
        tasksRepository.getFinishedTasksCount(categoryId)
    }

    fun addTasks(taskDbo: TaskDbo) {
        tasksRepository.addTasks(taskDbo)
    }


    fun addTitle(id: Int, title: String) {
        tasksRepository.insertTitle(id, title)
    }


    fun updateTask(id: Int, text: String) {
        tasksRepository.updateTask(id, text)
    }

    fun delete(taskId: Int) {
        tasksRepository.delete(taskId)
    }

    fun deleteByCategory(categoryId: Int) {
        tasksRepository.deleteByCategory(categoryId)
    }
}
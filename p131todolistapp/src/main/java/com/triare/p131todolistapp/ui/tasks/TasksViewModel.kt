package com.triare.p131todolistapp.ui.tasks

import androidx.lifecycle.ViewModel
import com.triare.p131todolistapp.data.model.TaskDbo
import com.triare.p131todolistapp.data.repository.TasksRepository

class TasksViewModel : ViewModel() {

    private val tasksRepository = TasksRepository()
    private val taskDbo: TaskDbo? = null

    fun addTasks() {
        if (taskDbo != null) {
            tasksRepository.addTasks(taskDbo)
        }

    }

}
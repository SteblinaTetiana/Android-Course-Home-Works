package com.triare.p131todolistapp.ui.todolist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.triare.p131todolistapp.data.model.CategoryDbo

class ToDoListViewModel : ViewModel() {

    private val _toDoListResult = MutableLiveData<CategoryDbo>()
    val toDoListResult: LiveData<CategoryDbo> = _toDoListResult

    fun list(view: View) {
        ToDoListFragmentDirections.actionToDoListFragmentToCreateNoteFragment(
        ).also {
            view.findNavController().navigate(it)
        }
    }
}
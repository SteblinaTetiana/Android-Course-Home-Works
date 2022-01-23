package com.triare.p131todolistapp.todolist

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.triare.p131todolistapp.model.ListNoteDvo

class ToDoListViewModel : ViewModel() {

    private val _toDoListResult = MutableLiveData<ListNoteDvo>()
    val toDoListResult: LiveData<ListNoteDvo> = _toDoListResult

   /* fun list(view: View, listNoteDvo: ListNoteDvo) {
        ToDoListFragmentDirections.actionToDoListFragmentToCreateNoteFragment(
            listNoteDvo
        ).also {
            view.findNavController().navigate(it)
        }
    }*/
}
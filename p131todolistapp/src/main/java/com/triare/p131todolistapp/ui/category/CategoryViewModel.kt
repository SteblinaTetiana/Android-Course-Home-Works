package com.triare.p131todolistapp.ui.category

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.data.repository.CategoryRepository

class CategoryViewModel : ViewModel() {

    private val categoryRepository = CategoryRepository()
    private val categoryDbo: CategoryDbo? = null

    private val _toDoListResult = MutableLiveData<CategoryDbo>()
    val toDoListResult: LiveData<CategoryDbo> = _toDoListResult

    fun addCategory() {
        categoryDbo?.let { categoryRepository.addCategories(it) }
    }

  /*  fun deleteAll() {
        userRepository.deleteAll()
    }*/

    fun list(view: View) {
        CategoryFragmentDirections.actionCategoryFragmentToTaskFragment(
        ).also {
            view.findNavController().navigate(it)
        }
    }
}
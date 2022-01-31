package com.triare.p131todolistapp.ui.category

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.data.repository.CategoryRepository

class CategoriesViewModel : ViewModel() {

    private val categoryRepository = CategoryRepository()

    private val _toDoListResult = MutableLiveData<CategoryDbo>()
    val toDoListResult: LiveData<CategoryDbo> = _toDoListResult

    fun addCategory(categoryDbo: CategoryDbo) {
        categoryRepository.addCategories(categoryDbo)
    }

    fun updateTitle(id: Int, title: String) {
        categoryRepository.updateTitle(id, title)
    }

}
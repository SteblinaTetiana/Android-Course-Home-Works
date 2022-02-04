package com.triare.p131todolistapp.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.data.repository.CategoryRepository

class CategoriesViewModel : ViewModel() {

    private val categoryRepository = CategoryRepository()

    val allCategories: LiveData<List<CategoryDbo>> = categoryRepository.getCategories()

    fun addCategory(id: Int, title: String, date: String) {
        categoryRepository.addCategories(CategoryDbo(id, title, date))
    }

    fun updateTitle(id: Int, title: String) {
        categoryRepository.updateTitle(id, title)
    }

}
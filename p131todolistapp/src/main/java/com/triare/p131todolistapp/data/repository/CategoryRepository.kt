package com.triare.p131todolistapp.data.repository

import androidx.lifecycle.LiveData
import com.triare.p131todolistapp.data.db.AppDatabase
import com.triare.p131todolistapp.data.model.CategoryDbo

class CategoryRepository {

    private val dbCategory = AppDatabase.getInstance()

    private val categoryDao = dbCategory.categoryDao()

    fun getCategories(): LiveData<List<CategoryDbo>> = categoryDao.getCategories()

    fun addCategories(categoryDbo: CategoryDbo) {
        categoryDao.insert(categoryDbo)
    }

    fun updateTitle(id: Int, title: String) {
        categoryDao.updateTitle(id, title)
    }

}
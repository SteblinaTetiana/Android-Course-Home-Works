package com.triare.p131todolistapp.data.repository

import androidx.lifecycle.LiveData
import com.triare.p131todolistapp.data.db.AppDatabase
import com.triare.p131todolistapp.data.model.CategoryDbo
import com.triare.p131todolistapp.data.remote.CategoryDataSource

class CategoryRepository {

    private val dbCategory = AppDatabase.getInstance()

    private val categoryDao = dbCategory.categoryDao()

    private val categoryDataSource = CategoryDataSource()

    fun getCategories(): LiveData<List<CategoryDbo>> = categoryDao.getCategories()

    fun addCategories(categoryDbo: CategoryDbo) {
        categoryDao.insert(categoryDbo)
    }

    fun updateTitle(id: Int, title: String) {
        categoryDao.updateTitle(id, title)
    }

    fun addCategory(category: CategoryDbo) {
        categoryDataSource.addCategory(category)
    }

}
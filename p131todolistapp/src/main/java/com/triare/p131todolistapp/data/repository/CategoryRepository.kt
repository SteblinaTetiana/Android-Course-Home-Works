package com.triare.p131todolistapp.data.repository

import com.triare.p131todolistapp.data.db.AppDatabaseCategory
import com.triare.p131todolistapp.data.model.CategoryDbo

class CategoryRepository {

    private val dbCategory = AppDatabaseCategory.getInstanceCategory()

    private val categoryDao = dbCategory.categoryDao()

    fun getCategories() = categoryDao.getCategories()

    fun addCategories(categoryDbo: CategoryDbo) {
        categoryDao.insert(categoryDbo)
    }

/*    fun updateTitle() {
        categoryDao.updateTitle(id = 1, )
    }*/

}
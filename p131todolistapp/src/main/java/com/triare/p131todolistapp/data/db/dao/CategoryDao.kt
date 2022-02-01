package com.triare.p131todolistapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.triare.p131todolistapp.data.model.CategoryDbo

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories ORDER BY id DESC")
    fun getCategories(): LiveData<List<CategoryDbo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryDbo: CategoryDbo)

    @Query("UPDATE categories SET title = :title WHERE id = :id")
    fun updateTitle(id: Int, title: String)

    /*  @Query("DELETE FROM tasks WHERE categoryId = :categoryId")
      fun delete(categoryId: Int)*/
}
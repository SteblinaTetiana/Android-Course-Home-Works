package com.triare.p131todolistapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.triare.p131todolistapp.data.model.TaskDbo

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<TaskDbo>>

    @Query("SELECT * FROM tasks WHERE categoryId = :categoryId ORDER BY id DESC")
    fun getTasks(categoryId: Int): List<TaskDbo>

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId")
    fun getTasksCount(categoryId: Int): Int

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId AND isFinished = 1")
    fun getFinishedTasksCount(categoryId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(taskDbo: TaskDbo)

    @Query("UPDATE categories SET title = :title WHERE id = :id")
    fun insertTitle(id: Int, title: String)

    @Query("UPDATE tasks SET text = :text WHERE id = :id")
    fun updateTask(id: Int, text: String)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    fun delete(taskId: Int)

    @Query("DELETE FROM tasks WHERE categoryId = :categoryId")
    fun deleteByCategory(categoryId: Int)
}
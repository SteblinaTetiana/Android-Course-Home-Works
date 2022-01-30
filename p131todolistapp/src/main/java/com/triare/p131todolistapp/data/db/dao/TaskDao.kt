package com.triare.p131todolistapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.triare.p131todolistapp.data.model.TaskDbo
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks WHERE categoryId = :categoryId ORDER BY id DESC")
    fun getTasks(categoryId: Int): LiveData<List<TaskDbo>>

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId")
    fun getTasksCount(categoryId: Int): Int

    @Query("SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId AND isFinished = 1")
    fun getFinishedTasksCount(categoryId: Int): Int

    @Insert
    fun insert(taskDbo: TaskDbo)

    @Query("UPDATE tasks SET text = :text WHERE id = :id")
    fun updateTask(id: Int, text: String)

    @Query("DELETE FROM tasks WHERE id = :taskId")
    fun delete(taskId: Int)

    @Query("DELETE FROM tasks WHERE categoryId = :categoryId")
    fun deleteByCategory(categoryId: Int)
}
package com.triare.p131todolistapp.data.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\'J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\'\u00a8\u0006\u0015"}, d2 = {"Lcom/triare/p131todolistapp/data/db/dao/TaskDao;", "", "delete", "", "taskId", "", "deleteByCategory", "categoryId", "getAllTasks", "Landroidx/lifecycle/LiveData;", "", "Lcom/triare/p131todolistapp/data/model/TaskDbo;", "getFinishedTasksCount", "getTasks", "getTasksCount", "insert", "taskDbo", "updateTask", "id", "text", "", "p131todolistapp_debug"})
public abstract interface TaskDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tasks")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.TaskDbo>> getAllTasks();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE categoryId = :categoryId ORDER BY id DESC")
    public abstract java.util.List<com.triare.p131todolistapp.data.model.TaskDbo> getTasks(int categoryId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId")
    public abstract int getTasksCount(int categoryId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM tasks WHERE categoryId = :categoryId AND isFinished = 1")
    public abstract int getFinishedTasksCount(int categoryId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.data.model.TaskDbo taskDbo);
    
    @androidx.room.Query(value = "UPDATE tasks SET text = :text WHERE id = :id")
    public abstract void updateTask(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String text);
    
    @androidx.room.Query(value = "DELETE FROM tasks WHERE id = :taskId")
    public abstract void delete(int taskId);
    
    @androidx.room.Query(value = "DELETE FROM tasks WHERE categoryId = :categoryId")
    public abstract void deleteByCategory(int categoryId);
}
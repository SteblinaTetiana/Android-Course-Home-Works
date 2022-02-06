package com.triare.p131todolistapp.ui.category_detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/triare/p131todolistapp/ui/category_detail/CategoryDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "allTasks", "Landroidx/lifecycle/LiveData;", "", "Lcom/triare/p131todolistapp/data/model/TaskDbo;", "getAllTasks", "()Landroidx/lifecycle/LiveData;", "tasksRepository", "Lcom/triare/p131todolistapp/data/repository/TasksRepository;", "addData", "", "id", "", "categoryId", "text", "", "isFinished", "", "addTasks", "taskDbo", "delete", "taskId", "deleteByCategory", "getFinishedTasksCount", "getTasks", "getTasksCount", "updateTask", "p131todolistapp_debug"})
public final class CategoryDetailViewModel extends androidx.lifecycle.ViewModel {
    private final com.triare.p131todolistapp.data.repository.TasksRepository tasksRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.TaskDbo>> allTasks = null;
    
    public CategoryDetailViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.TaskDbo>> getAllTasks() {
        return null;
    }
    
    public final void getTasks(int categoryId) {
    }
    
    public final void getTasksCount(int categoryId) {
    }
    
    public final void getFinishedTasksCount(int categoryId) {
    }
    
    public final void addData(int id, int categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String text, boolean isFinished) {
    }
    
    public final void addTasks(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.data.model.TaskDbo taskDbo) {
    }
    
    private final void updateTask(int id, java.lang.String text) {
    }
    
    public final void delete(int taskId) {
    }
    
    public final void deleteByCategory(int categoryId) {
    }
}
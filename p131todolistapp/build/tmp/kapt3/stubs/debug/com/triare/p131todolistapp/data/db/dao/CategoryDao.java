package com.triare.p131todolistapp.data.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/triare/p131todolistapp/data/db/dao/CategoryDao;", "", "getCategories", "Landroidx/lifecycle/LiveData;", "", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "insert", "", "categoryDbo", "updateTitle", "id", "", "title", "", "p131todolistapp_debug"})
public abstract interface CategoryDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM categories ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo>> getCategories();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.data.model.CategoryDbo categoryDbo);
    
    @androidx.room.Query(value = "UPDATE categories SET title = :title WHERE id = :id")
    public abstract void updateTitle(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title);
}
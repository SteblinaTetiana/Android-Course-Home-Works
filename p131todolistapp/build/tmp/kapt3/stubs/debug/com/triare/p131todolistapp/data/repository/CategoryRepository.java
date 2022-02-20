package com.triare.p131todolistapp.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\fJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/triare/p131todolistapp/data/repository/CategoryRepository;", "", "()V", "categoryDao", "Lcom/triare/p131todolistapp/data/db/dao/CategoryDao;", "dbCategory", "Lcom/triare/p131todolistapp/data/db/AppDatabase;", "addCategories", "", "categoryDbo", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "getCategories", "Landroidx/lifecycle/LiveData;", "", "updateTitle", "id", "", "title", "", "p131todolistapp_debug"})
public final class CategoryRepository {
    private final com.triare.p131todolistapp.data.db.AppDatabase dbCategory = null;
    private final com.triare.p131todolistapp.data.db.dao.CategoryDao categoryDao = null;
    
    public CategoryRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo>> getCategories() {
        return null;
    }
    
    public final void addCategories(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.data.model.CategoryDbo categoryDbo) {
    }
    
    public final void updateTitle(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
}
package com.triare.p131todolistapp.ui.categories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/triare/p131todolistapp/ui/categories/CategoriesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "allCategories", "Landroidx/lifecycle/LiveData;", "", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "getAllCategories", "()Landroidx/lifecycle/LiveData;", "categoryRepository", "Lcom/triare/p131todolistapp/data/repository/CategoryRepository;", "addCategory", "", "id", "", "title", "", "date", "updateTitle", "p131todolistapp_debug"})
public final class CategoriesViewModel extends androidx.lifecycle.ViewModel {
    private final com.triare.p131todolistapp.data.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo>> allCategories = null;
    
    public CategoriesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo>> getAllCategories() {
        return null;
    }
    
    public final void addCategory(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String date) {
    }
    
    public final void updateTitle(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
}
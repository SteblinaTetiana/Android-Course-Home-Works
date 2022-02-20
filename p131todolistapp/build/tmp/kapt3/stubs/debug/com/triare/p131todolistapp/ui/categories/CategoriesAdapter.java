package com.triare.p131todolistapp.ui.categories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$CategoryViewHolder;", "clickListener", "Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$OnItemClickListener;", "(Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$OnItemClickListener;)V", "getClickListener", "()Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$OnItemClickListener;", "value", "", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "listCategories", "getListCategories", "()Ljava/util/List;", "setListCategories", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CategoryViewHolder", "OnItemClickListener", "p131todolistapp_debug"})
public final class CategoriesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.triare.p131todolistapp.ui.categories.CategoriesAdapter.CategoryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.triare.p131todolistapp.ui.categories.CategoriesAdapter.OnItemClickListener clickListener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo> listCategories;
    
    public CategoriesAdapter(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.ui.categories.CategoriesAdapter.OnItemClickListener clickListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.triare.p131todolistapp.ui.categories.CategoriesAdapter.OnItemClickListener getClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo> getListCategories() {
        return null;
    }
    
    public final void setListCategories(@org.jetbrains.annotations.NotNull()
    java.util.List<com.triare.p131todolistapp.data.model.CategoryDbo> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.triare.p131todolistapp.ui.categories.CategoriesAdapter.CategoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.ui.categories.CategoriesAdapter.CategoryViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$OnItemClickListener;", "", "onClick", "", "category", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "p131todolistapp_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.triare.p131todolistapp.data.model.CategoryDbo category);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter$CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/triare/p131todolistapp/ui/categories/CategoriesAdapter;Landroid/view/View;)V", "bind", "", "listCategory", "Lcom/triare/p131todolistapp/data/model/CategoryDbo;", "p131todolistapp_debug"})
    public final class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        
        public CategoryViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.triare.p131todolistapp.data.model.CategoryDbo listCategory) {
        }
    }
}
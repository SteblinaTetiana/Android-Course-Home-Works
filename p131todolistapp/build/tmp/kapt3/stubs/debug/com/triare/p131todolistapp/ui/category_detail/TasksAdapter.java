package com.triare.p131todolistapp.ui.category_detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/triare/p131todolistapp/ui/category_detail/TasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/triare/p131todolistapp/ui/category_detail/TasksAdapter$TasksViewHolder;", "()V", "categoryDetailViewModel", "Lcom/triare/p131todolistapp/ui/category_detail/CategoryDetailViewModel;", "database", "Lcom/triare/p131todolistapp/data/db/AppDatabase;", "value", "", "Lcom/triare/p131todolistapp/data/model/TaskDbo;", "listTasks", "getListTasks", "()Ljava/util/List;", "setListTasks", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TasksViewHolder", "p131todolistapp_debug"})
public final class TasksAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.triare.p131todolistapp.ui.category_detail.TasksAdapter.TasksViewHolder> {
    private com.triare.p131todolistapp.ui.category_detail.CategoryDetailViewModel categoryDetailViewModel;
    private com.triare.p131todolistapp.data.db.AppDatabase database;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.triare.p131todolistapp.data.model.TaskDbo> listTasks;
    
    public TasksAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.triare.p131todolistapp.data.model.TaskDbo> getListTasks() {
        return null;
    }
    
    public final void setListTasks(@org.jetbrains.annotations.NotNull()
    java.util.List<com.triare.p131todolistapp.data.model.TaskDbo> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.triare.p131todolistapp.ui.category_detail.TasksAdapter.TasksViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.triare.p131todolistapp.ui.category_detail.TasksAdapter.TasksViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/triare/p131todolistapp/ui/category_detail/TasksAdapter$TasksViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/triare/p131todolistapp/ui/category_detail/TasksAdapter;Landroid/view/View;)V", "bind", "", "listTask", "Lcom/triare/p131todolistapp/data/model/TaskDbo;", "p131todolistapp_debug"})
    public final class TasksViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        
        public TasksViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.triare.p131todolistapp.data.model.TaskDbo listTask) {
        }
    }
}
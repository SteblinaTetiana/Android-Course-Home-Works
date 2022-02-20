package com.triare.p131todolistapp.data.db;

import java.lang.System;

@androidx.room.Database(entities = {com.triare.p131todolistapp.data.model.CategoryDbo.class, com.triare.p131todolistapp.data.model.TaskDbo.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/triare/p131todolistapp/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "categoryDao", "Lcom/triare/p131todolistapp/data/db/dao/CategoryDao;", "taskDao", "Lcom/triare/p131todolistapp/data/db/dao/TaskDao;", "Companion", "p131todolistapp_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.triare.p131todolistapp.data.db.AppDatabase.Companion Companion = null;
    private static com.triare.p131todolistapp.data.db.AppDatabase instance;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.triare.p131todolistapp.data.db.dao.CategoryDao categoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.triare.p131todolistapp.data.db.dao.TaskDao taskDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/triare/p131todolistapp/data/db/AppDatabase$Companion;", "", "()V", "instance", "Lcom/triare/p131todolistapp/data/db/AppDatabase;", "getInstance", "p131todolistapp_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.triare.p131todolistapp.data.db.AppDatabase getInstance() {
            return null;
        }
    }
}
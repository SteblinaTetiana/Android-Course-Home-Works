package com.triare.p131todolistapp.data.db.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.triare.p131todolistapp.data.model.TaskDbo;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TaskDbo> __insertionAdapterOfTaskDbo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTask;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByCategory;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaskDbo = new EntityInsertionAdapter<TaskDbo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tasks` (`id`,`categoryId`,`text`,`isFinished`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskDbo value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getCategoryId());
        if (value.getText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getText());
        }
        final int _tmp = value.isFinished() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__preparedStmtOfUpdateTask = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tasks SET text = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tasks WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByCategory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tasks WHERE categoryId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final TaskDbo taskDbo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTaskDbo.insert(taskDbo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(final int id, final String text) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTask.acquire();
    int _argIndex = 1;
    if (text == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, text);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateTask.release(_stmt);
    }
  }

  @Override
  public void delete(final int taskId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, taskId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void deleteByCategory(final int categoryId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByCategory.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, categoryId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByCategory.release(_stmt);
    }
  }

  @Override
  public LiveData<List<TaskDbo>> getAllTasks() {
    final String _sql = "SELECT `tasks`.`id` AS `id`, `tasks`.`categoryId` AS `categoryId`, `tasks`.`text` AS `text`, `tasks`.`isFinished` AS `isFinished` FROM tasks";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tasks"}, false, new Callable<List<TaskDbo>>() {
      @Override
      public List<TaskDbo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfCategoryId = 1;
          final int _cursorIndexOfText = 2;
          final int _cursorIndexOfIsFinished = 3;
          final List<TaskDbo> _result = new ArrayList<TaskDbo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TaskDbo _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpCategoryId;
            _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
            final String _tmpText;
            if (_cursor.isNull(_cursorIndexOfText)) {
              _tmpText = null;
            } else {
              _tmpText = _cursor.getString(_cursorIndexOfText);
            }
            final boolean _tmpIsFinished;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFinished);
            _tmpIsFinished = _tmp != 0;
            _item = new TaskDbo(_tmpId,_tmpCategoryId,_tmpText,_tmpIsFinished);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<TaskDbo> getTasks(final int categoryId) {
    final String _sql = "SELECT * FROM tasks WHERE categoryId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoryId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryId");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfIsFinished = CursorUtil.getColumnIndexOrThrow(_cursor, "isFinished");
      final List<TaskDbo> _result = new ArrayList<TaskDbo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaskDbo _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpCategoryId;
        _tmpCategoryId = _cursor.getInt(_cursorIndexOfCategoryId);
        final String _tmpText;
        if (_cursor.isNull(_cursorIndexOfText)) {
          _tmpText = null;
        } else {
          _tmpText = _cursor.getString(_cursorIndexOfText);
        }
        final boolean _tmpIsFinished;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFinished);
        _tmpIsFinished = _tmp != 0;
        _item = new TaskDbo(_tmpId,_tmpCategoryId,_tmpText,_tmpIsFinished);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getTasksCount(final int categoryId) {
    final String _sql = "SELECT COUNT(*) FROM tasks WHERE categoryId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoryId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getFinishedTasksCount(final int categoryId) {
    final String _sql = "SELECT COUNT(*) FROM tasks WHERE categoryId = ? AND isFinished = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoryId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

package com.triare.p131todolistapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.triare.p131todolistapp.data.model.ListNoteDbo

@Dao
interface ListNoteDao {

    @Query("SELECT * FROM notes")
    fun getAll(): List<ListNoteDbo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listNoteDbo: ListNoteDbo): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(listNoteDbo: ListNoteDbo)

    @Delete
    fun delete(listNoteDbo: ListNoteDbo)

}
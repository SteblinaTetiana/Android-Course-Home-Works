package com.triare.p131todolistapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class ListNoteDbo(
    @PrimaryKey
    val id: Int,
    val title: String,
    val date: String,
    val numberNote: String,
)

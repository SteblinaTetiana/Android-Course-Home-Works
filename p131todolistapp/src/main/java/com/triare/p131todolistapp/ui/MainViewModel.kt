package com.triare.p131todolistapp.ui

import androidx.lifecycle.ViewModel
import com.triare.p131todolistapp.data.repository.NoteRepository

class MainViewModel: ViewModel() {

    private val noteRepository = NoteRepository()
}
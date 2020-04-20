package com.example.level5_task1

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepo = NoteRepo(application.applicationContext)
    val note = noteRepo.getNotePad()
}
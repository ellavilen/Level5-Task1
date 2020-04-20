package com.example.level5_task1

import android.content.Context
import androidx.lifecycle.LiveData

class NoteRepo(context: Context) {
    private val noteDao: NoteDao

    init {
        val database = NoteRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotePad(): LiveData<Note?>{
        return noteDao.getNotePad()
    }

    suspend fun updateNotepad(note : Note){
        noteDao.updateNote(note)
    }
}
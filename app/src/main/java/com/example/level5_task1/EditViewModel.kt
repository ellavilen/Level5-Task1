package com.example.level5_task1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepo = NoteRepo(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.IO)

    val note = MutableLiveData<Note?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()

    fun updateNote(){
        if (isNoteValid()){
            mainScope.launch {
                withContext(Dispatchers.IO){
                    noteRepo.updateNotepad(note.value!!)
                }
                success.value = true
            }
        }
    }
    private fun isNoteValid() : Boolean{
        return when {
            note.value == null -> {
                error.value = "Note must not be null"
                false
            }
            note.value!!.title.isBlank()->{
                error.value = "Title can't be null"
                false
            }
            else -> true
        }
    }
}
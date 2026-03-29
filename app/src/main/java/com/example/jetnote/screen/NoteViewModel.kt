package com.example.jetnote.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.NoteDataSource
import com.example.jetnote.model.Note
import com.example.jetnote.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    //private var noteList = mutableStateListOf<Note>()

    init {
        //noteList.addAll(NoteDataSource().loadNotes())
        viewModelScope.launch(Dispatchers.IO) {

            repository.getAllNote().distinctUntilChanged()
                .collect { listOfNotes->
                    if (listOfNotes.isNullOrEmpty()){
                        Log.d("Empty",": Empty list")
                    }else{
                        _noteList.value = listOfNotes
                    }

                }
        }
    }

     fun addNote(note: Note) = viewModelScope.launch {
        repository.addNote(note)
    }

     fun removeNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

     fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

}
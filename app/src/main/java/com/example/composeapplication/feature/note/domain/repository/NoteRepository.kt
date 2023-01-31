package com.example.composeapplication.feature.note.domain.repository

import com.example.composeapplication.feature.note.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getNotes() : Flow<List<com.example.composeapplication.feature.note.domain.model.Note>>

    suspend fun getNoteById(id : Int) : com.example.composeapplication.feature.note.domain.model.Note?

    suspend fun insertNote(note: com.example.composeapplication.feature.note.domain.model.Note)

    suspend fun deleteNote(note: com.example.composeapplication.feature.note.domain.model.Note)
}
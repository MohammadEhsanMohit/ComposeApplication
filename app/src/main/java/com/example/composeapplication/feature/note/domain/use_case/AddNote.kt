package com.example.composeapplication.feature.note.domain.use_case

import com.example.composeapplication.feature.note.domain.model.InvalidNoteException
import com.example.composeapplication.feature.note.domain.model.Note
import com.example.composeapplication.feature.note.domain.repository.NoteRepository

class AddNote(
    private val repository: com.example.composeapplication.feature.note.domain.repository.NoteRepository
) {
    @Throws(com.example.composeapplication.feature.note.domain.model.InvalidNoteException::class)
    suspend operator fun invoke(note: com.example.composeapplication.feature.note.domain.model.Note) {
        if(note.title.isBlank()) {
            throw com.example.composeapplication.feature.note.domain.model.InvalidNoteException("The Title of the note can't be empty")
        }
        if(note.content.isBlank()) {
            throw com.example.composeapplication.feature.note.domain.model.InvalidNoteException("The Content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}
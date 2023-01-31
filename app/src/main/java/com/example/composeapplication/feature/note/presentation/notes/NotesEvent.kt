package com.example.composeapplication.feature.note.presentation.notes

import com.example.composeapplication.feature.note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: com.example.composeapplication.feature.note.domain.model.Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}

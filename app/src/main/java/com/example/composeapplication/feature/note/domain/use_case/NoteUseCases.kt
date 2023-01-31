package com.example.composeapplication.feature.note.domain.use_case

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNote: com.example.composeapplication.feature.note.domain.use_case.AddNote,
    val getNote : GetNoteUseCase
)
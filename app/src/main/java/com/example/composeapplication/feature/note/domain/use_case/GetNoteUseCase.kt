package com.example.composeapplication.feature.note.domain.use_case

import com.example.composeapplication.feature.note.domain.model.Note
import com.example.composeapplication.feature.note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: com.example.composeapplication.feature.note.domain.repository.NoteRepository
) {

    suspend operator fun invoke(id:Int) : com.example.composeapplication.feature.note.domain.model.Note? = repository.getNoteById(id)
}
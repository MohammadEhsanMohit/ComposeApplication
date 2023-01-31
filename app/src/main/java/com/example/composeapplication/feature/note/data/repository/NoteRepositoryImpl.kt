package com.example.composeapplication.feature.note.data.repository

import com.example.composeapplication.feature.note.data.data_source.NoteDao
import com.example.composeapplication.feature.note.domain.model.Note
import com.example.composeapplication.feature.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: com.example.composeapplication.feature.note.data.data_source.NoteDao
) : com.example.composeapplication.feature.note.domain.repository.NoteRepository {
    override fun getNotes(): Flow<List<com.example.composeapplication.feature.note.domain.model.Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): com.example.composeapplication.feature.note.domain.model.Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: com.example.composeapplication.feature.note.domain.model.Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: com.example.composeapplication.feature.note.domain.model.Note) {
        dao.deleteNote(note)
    }
}
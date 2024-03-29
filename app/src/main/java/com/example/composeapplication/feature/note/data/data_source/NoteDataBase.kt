package com.example.composeapplication.feature.note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapplication.feature.note.domain.model.Note


@Database(entities = [Note::class],
version = 1)
abstract class NoteDataBase  : RoomDatabase() {

    abstract val noteDao : NoteDao

    companion object {
        val DATABASE_NAME = "notes_db"
    }
}
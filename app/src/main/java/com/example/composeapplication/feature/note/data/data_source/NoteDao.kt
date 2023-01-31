package com.example.composeapplication.feature.note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composeapplication.feature.note.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("select * from Note")
    fun getNotes() : Flow<List<com.example.composeapplication.feature.note.domain.model.Note>>


    @Query("Select * from note where id = :id")
    suspend fun getNoteById(id:Int) : com.example.composeapplication.feature.note.domain.model.Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: com.example.composeapplication.feature.note.domain.model.Note)

    @Delete
    suspend fun deleteNote(note: com.example.composeapplication.feature.note.domain.model.Note)
}
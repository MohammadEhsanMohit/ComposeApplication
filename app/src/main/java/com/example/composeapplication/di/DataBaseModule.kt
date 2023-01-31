package com.example.composeapplication.di

import android.app.Application
import androidx.room.Room
import com.example.composeapplication.feature.note.data.data_source.NoteDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBase = module {
    single { provideNoteDataBase(androidApplication()) }
    factory { provideNoteDao(get()) }
}

fun provideNoteDao(db: com.example.composeapplication.feature.note.data.data_source.NoteDataBase) = db.noteDao

fun provideNoteDataBase(androidApplication: Application) = Room.databaseBuilder(
    androidApplication,
    com.example.composeapplication.feature.note.data.data_source.NoteDataBase::class.java,
    com.example.composeapplication.feature.note.data.data_source.NoteDataBase.DATABASE_NAME
).build()



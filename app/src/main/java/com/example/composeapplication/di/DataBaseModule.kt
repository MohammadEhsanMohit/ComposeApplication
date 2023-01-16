package com.example.composeapplication.di

import android.app.Application
import androidx.room.Room
import com.example.composeapplication.feature_note.data.data_source.NoteDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBase = module {
    single { provideNoteDataBase(androidApplication()) }
    factory { provideNoteDao(get()) }
}

fun provideNoteDao(db: NoteDataBase) = db.noteDao

fun provideNoteDataBase(androidApplication: Application) = Room.databaseBuilder(
    androidApplication,
    NoteDataBase::class.java,
    NoteDataBase.DATABASE_NAME
).build()



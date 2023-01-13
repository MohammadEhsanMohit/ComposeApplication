package com.example.composeapplication.di

import com.example.composeapplication.feature_note.data.repository.NoteRepositoryImpl
import com.example.composeapplication.feature_note.domain.repository.NoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<NoteRepository> { NoteRepositoryImpl(get()) }
}
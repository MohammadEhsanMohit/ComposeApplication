package com.example.composeapplication.di

import com.example.composeapplication.feature.note.data.repository.NoteRepositoryImpl
import com.example.composeapplication.feature.note.domain.repository.NoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<com.example.composeapplication.feature.note.domain.repository.NoteRepository> {
        com.example.composeapplication.feature.note.data.repository.NoteRepositoryImpl(
            get()
        )
    }
}
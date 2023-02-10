package com.example.composeapplication.di

import com.example.composeapplication.feature.note.data.repository.NoteRepositoryImpl
import com.example.composeapplication.feature.note.domain.repository.NoteRepository
import com.example.composeapplication.feature.splash.data.repository.SplashScreenRepositoryImp
import com.example.composeapplication.feature.splash.domain.repository.SplashScreenRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<NoteRepository> {
        NoteRepositoryImpl(
            get()
        )
    }
    factory<SplashScreenRepository> {
        SplashScreenRepositoryImp()
    }
}
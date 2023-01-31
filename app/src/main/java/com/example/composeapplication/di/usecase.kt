package com.example.composeapplication.di

import com.example.composeapplication.feature.note.domain.use_case.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { NoteUseCases(
        GetNotesUseCase(get()),
        DeleteNoteUseCase(get()),
        AddNote(get()),
        GetNoteUseCase(get())
    ) }
}
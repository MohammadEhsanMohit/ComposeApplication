package com.example.composeapplication.feature_note.presentation.util

import com.example.utils.FeatureRoutesNAME.NOTES_LIST_SCREEN
import com.example.utils.FeatureRoutesNAME.NOTE_ADD_EDIT_SCREEN

sealed class Screen(val route: String) {
    object NotesScreen : Screen(NOTES_LIST_SCREEN)
    object AddEditNoteScreen : Screen(NOTE_ADD_EDIT_SCREEN)
}

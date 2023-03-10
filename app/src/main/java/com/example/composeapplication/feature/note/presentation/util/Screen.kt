package com.example.composeapplication.feature.note.presentation.util

import com.example.composeapplication.navigation.RouteConstant.FeatureRoutesNAME.NOTES_LIST_SCREEN
import com.example.composeapplication.navigation.RouteConstant.FeatureRoutesNAME.NOTE_ADD_EDIT_SCREEN

sealed class Screen(val route: String) {
    object NotesScreen : Screen(NOTES_LIST_SCREEN)
    object AddEditNoteScreen : Screen(NOTE_ADD_EDIT_SCREEN)
}
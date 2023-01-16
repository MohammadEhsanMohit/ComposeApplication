package com.example.composeapplication.utils

import com.example.composeapplication.utils.FeatureRoutesNAME.NOTE_ADD_EDIT_SCREEN

object MainRoutes {

}

object FeatureRoutesNAME {
    const val NOTES_LIST_SCREEN = "notes_screen"
    const val NOTE_ADD_EDIT_SCREEN = "add_edit_note_screen"
}

object NotesNavLinkPARAM {
    const val NOTES_LIST_SCREEN_URL_PARAMETER = "$NOTE_ADD_EDIT_SCREEN?noteId={noteId}&noteColor={noteColor}"
}
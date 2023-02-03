package com.example.composeapplication.navigation

import com.example.composeapplication.navigation.RouteConstant.FeatureRoutesNAME.NOTE_ADD_EDIT_SCREEN

object RouteConstant {
    const val NOTE_SCREEN = "noteScreen"

    object FeatureRoutesNAME {
        const val NOTES_LIST_SCREEN = "notes_screen"
        const val NOTE_ADD_EDIT_SCREEN = "add_edit_note_screen"
    }

    object NotesNavLinkPARAM {
        const val NOTES_LIST_SCREEN_URL_PARAMETER = "$NOTE_ADD_EDIT_SCREEN?noteId={noteId}&noteColor={noteColor}"
    }


    //Bottom Nav
    const val BOTTOM_PROFILE_ROUTE = "profile"
    const val BOTTOM_RECIPE_LIST_ROUTE= "RecipeList"
    const val BOTTOM_PAGE_ROUTE = "BottomPage"
}
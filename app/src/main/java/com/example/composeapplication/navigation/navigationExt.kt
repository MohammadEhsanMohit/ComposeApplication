package com.example.composeapplication.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.composeapplication.feature.note.presentation.add_edit_note.AddEditNoteScreen
import com.example.composeapplication.feature.note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.composeapplication.feature.note.presentation.notes.NoteScreen
import com.example.composeapplication.feature.note.presentation.util.Screen
import com.example.composeapplication.navigation.RouteConstant.NOTE_SCREEN
import com.example.composeapplication.navigation.RouteConstant.NotesNavLinkPARAM.NOTES_LIST_SCREEN_URL_PARAMETER
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.noteGraph(navController : NavController) {
    navigation(startDestination = Screen.NotesScreen.route, route = NOTE_SCREEN) {
        composable(route = Screen.NotesScreen.route) {
            NoteScreen(navController = navController)
        }
        composable(route = NOTES_LIST_SCREEN_URL_PARAMETER,
            arguments =
            listOf(
                navArgument(name = "noteId") {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = "noteColor") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            val noteId = it.arguments?.getInt("noteId") ?: -1
            val viewModel = getViewModel<AddEditNoteViewModel>(
                parameters = { parametersOf(noteId) }
            )
            AddEditNoteScreen(
                navController = navController,
                noteColor = color,
                viewModel = viewModel
            )
        }
    }
}
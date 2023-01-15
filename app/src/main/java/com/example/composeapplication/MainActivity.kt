package com.example.composeapplication

import BottomBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeapplication.common.mainActivityConstraintSet
import com.example.composeapplication.data.BottomNavigationItem
import com.example.composeapplication.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.composeapplication.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.composeapplication.feature_note.presentation.notes.NoteScreen
import com.example.composeapplication.feature_note.presentation.util.Screen
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.*
import com.example.composeapplication.view.recipe.RecipeCard
import com.example.composeapplication.view.recipe.RecipeList
import com.example.composeapplication.view.recipe.recipeList
import com.example.composeapplication.view.recipe.sampleRecipe
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf
import com.example.composeapplication.feature_note.presentation.util.Screen as noteRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = noteRoute.NotesScreen.route
                    ) {
                        composable(route = noteRoute.NotesScreen.route) {
                            NoteScreen(navController = navController)
                        }
                        composable(route = noteRoute.AddEditNoteScreen.route +
                                "?noteId={noteId}&noteColor={noteColor}",
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
                // A surface container using the 'background' color from the theme

                //MainScreenView()

                // RecipeList(recipes = recipeList)
            }
        }
    }
}

@Composable
fun MainActivityCustomView() {
    Surface(
        modifier = Modifier.wrapContentSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BoxWithConstraints(
            Modifier.fillMaxSize(),
        ) {
            ConstraintLayout(mainActivityConstraintSet(5.dp, sampleRecipe.id)) {
                ProfilePageNew()
                RecipeCard(recipe = sampleRecipe, 16.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        RecipeList(recipes = recipeList)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItem.Profile.screen_route) {
        composable(BottomNavigationItem.Profile.screen_route) {
            ProfilePage()
        }
        composable(BottomNavigationItem.ProfileList.screen_route) {
            ProfilePageNew()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { padding ->
        NavHost(
            navController,
            startDestination = BottomNavigationItem.Profile.screen_route,
            Modifier.padding(padding)
        ) {
            composable(BottomNavigationItem.Profile.screen_route) {
                ProfilePage()
            }
            composable(BottomNavigationItem.ProfileList.screen_route) {
                ProfilePageNew()
            }

        }


    }


}

package com.example.composeapplication

import BottomBar
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
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
import com.example.composeapplication.data.model.MenuItem
import com.example.composeapplication.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.composeapplication.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.composeapplication.feature_note.presentation.notes.NoteScreen
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.utils.NotesNavLinkPARAM.NOTES_LIST_SCREEN_URL_PARAMETER
import com.example.composeapplication.view.*
import com.example.composeapplication.view.menu.AppBar
import com.example.composeapplication.view.menu.DrawerBody
import com.example.composeapplication.view.menu.DrawerHeader
import com.example.composeapplication.view.recipe.RecipeCard
import com.example.composeapplication.view.recipe.RecipeList
import com.example.composeapplication.view.recipe.recipeList
import com.example.composeapplication.view.recipe.sampleRecipe
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf
import com.example.composeapplication.feature_note.presentation.util.Screen as noteRoute

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            ComposeApplicationTheme {
                ModalNavigationDrawer(
                    scrimColor = MaterialTheme.colorScheme.background,
                    drawerState = drawerState,
                    drawerContent = {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            DrawerHeader()
                            DrawerBody(
                                items = listOf(
                                    MenuItem(
                                        id = "Home",
                                        title = "Profile",
                                        icon = Icons.Default.Person,
                                        contentDescription = "Here is Home Screen"
                                    ),
                                    MenuItem(
                                        id = "Setting",
                                        title = "FoodList",
                                        icon = Icons.Default.FavoriteBorder,
                                        contentDescription = "Here is Setting Screen"
                                    ),
                                    MenuItem(
                                        id = "Note",
                                        title = "Note",
                                        icon = Icons.Default.AccountBox,
                                        contentDescription = "Here is Info Screen"
                                    )
                                ),
                                modifier = Modifier.fillMaxWidth(),
                                onItemClick = {
                                    scope.launch { drawerState.close() }
                                    when(it.id) {
                                        "Home" -> navController.navigate(BottomNavigationItem.ProfileList.screen_route)
                                        "Setting" -> navController.navigate(BottomNavigationItem.RecipeList.screen_route)
                                        "Note" -> navController.navigate(noteRoute.NotesScreen.route)
                                    }
                                    println("Click On DrawerMenu: ${it.title}")
                                }
                            )
                        }

                    }) {
                    Scaffold(
                        topBar = {
                            AppBar {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        }
                    ) { padding ->
                        println("Padding : ${padding.calculateTopPadding()}")
                        NavHost(
                            modifier= Modifier.padding(top= padding.calculateTopPadding()),
                            navController = navController,
                            startDestination = BottomNavigationItem.ProfileList.screen_route
                        ) {
                            composable(route = noteRoute.NotesScreen.route) {
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
                            composable(BottomNavigationItem.Profile.screen_route) {
                                ProfilePage()
                            }
                            composable(BottomNavigationItem.ProfileList.screen_route) {
                                ProfilePageNew()
                            }
                            composable(BottomNavigationItem.RecipeList.screen_route) {
                                RecipeList(recipes = recipeList)
                            }
                        }
                    }
                }
                /*Surface(
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
                }*/
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

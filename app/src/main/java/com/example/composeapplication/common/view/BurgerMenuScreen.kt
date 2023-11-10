package com.example.composeapplication.common.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.data.BottomNavigationItem.Note
import com.example.composeapplication.data.BottomNavigationItem.RecipeList
import com.example.composeapplication.data.BottomNavigationItem.Profile
import com.example.composeapplication.data.model.MenuItem
import com.example.composeapplication.feature.note.presentation.util.Screen
import com.example.composeapplication.navigation.RouteConstant.BOTTOM_PAGE_ROUTE
import com.example.composeapplication.navigation.noteGraph
import com.example.composeapplication.view.ProfilePage
import com.example.composeapplication.view.ProfilePageNew
import com.example.composeapplication.view.mainactivity.MainScreenView
import com.example.composeapplication.view.menu.AppBar
import com.example.composeapplication.view.menu.DrawerBody
import com.example.composeapplication.view.menu.DrawerHeader
import com.example.composeapplication.feature.recipe.presentation.RecipeList
import com.example.composeapplication.feature.recipe.presentation.recipeList
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerMenuScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        scrimColor = MaterialTheme.colorScheme.background,
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .requiredWidth(250.dp)
                    .fillMaxHeight()
            ) {
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
                        ),
                        MenuItem(
                            id = "Bottom",
                            title = "BottomBar",
                            icon = Icons.Default.PlayArrow,
                            contentDescription = "Here is Bottom Bar Screen"
                        )
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    onItemClick = {
                        scope.launch { drawerState.close() }
                        when (it.id) {
                            "Home" -> navController.navigate(Note.screen_route)
                            "Setting" -> navController.navigate(RecipeList.screen_route)
                            "Note" -> navController.navigate(Screen.NotesScreen.route)
                            "Bottom" -> navController.navigate("BottomPage")
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
                modifier = Modifier.padding(top = padding.calculateTopPadding()),
                navController = navController,
                startDestination = Note.screen_route
            ) {
                noteGraph(navController)
                composable(Profile.screen_route) {
                    ProfilePage()
                }
                composable(Note.screen_route) {
                    ProfilePageNew()
                }
                composable(RecipeList.screen_route) {
                    RecipeList(recipes = recipeList)
                }
                composable(BOTTOM_PAGE_ROUTE) {
                    MainScreenView()
                }
            }
        }
    }
}
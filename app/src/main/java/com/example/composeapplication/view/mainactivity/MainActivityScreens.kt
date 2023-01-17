package com.example.composeapplication.view

import BottomBar
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.common.mainActivityConstraintSet
import com.example.composeapplication.data.BottomNavigationItem
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.recipe.RecipeCard
import com.example.composeapplication.view.recipe.sampleRecipe

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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        MainScreenView()
    }
}
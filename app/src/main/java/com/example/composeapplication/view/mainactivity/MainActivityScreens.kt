package com.example.composeapplication.view.mainactivity

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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.composeapplication.common.mainActivityConstraintSet
import com.example.composeapplication.data.BottomNavigationItem
import com.example.composeapplication.navigation.noteGraph
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.ProfilePageNew
import com.example.composeapplication.feature.recipe.presentation.RecipeList
import com.example.composeapplication.feature.recipe.presentation.recipeList
import com.example.composeapplication.feature.recipe.presentation.sampleRecipe
import com.example.composeapplication.utils.RECIPE_LINK
import com.example.composeapplication.utils.SCHEMA

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
                MainScreenView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        bottomBar = { BottomBar(navController = navController) }
    ) { padding ->
        NavHost(
            navController,
            startDestination = BottomNavigationItem.Profile.screen_route,
            Modifier.padding(padding)
        ) {
            composable(BottomNavigationItem.Profile.screen_route) {
                ProfilePageNew()
            }
            noteGraph(navController)
            composable(BottomNavigationItem.RecipeList.screen_route,
                deepLinks = listOf(
                    navDeepLink { uriPattern = "$SCHEMA$RECIPE_LINK" }
                )
            ) {
                RecipeList(recipes = recipeList)
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
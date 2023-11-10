package com.example.composeapplication.feature.recipe.presentation


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.composeapplication.feature.recipe.domain.model.Recipe
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn {
        items(recipes) { item ->
            RecipeCard(recipe = item, 16.dp)
        }
    }
}

package com.example.composeapplication.view.recipe


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.composeapplication.data.model.Recipe
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.composeapplication.view.recipe.RecipeCard

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn {
        items(recipes) { item ->
            RecipeCard(recipe = item, 16.dp)
        }
    }
}

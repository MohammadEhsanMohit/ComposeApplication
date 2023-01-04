package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composeapplication.common.mainActivityConstraintSet
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.*
import com.example.composeapplication.view.recipe.RecipeCard
import com.example.composeapplication.view.recipe.RecipeList
import com.example.composeapplication.view.recipe.recipeList
import com.example.composeapplication.view.recipe.sampleRecipe

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                RecipeList(recipes = recipeList)
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
        BoxWithConstraints(Modifier.fillMaxSize(),
        ) {
            ConstraintLayout(mainActivityConstraintSet(5.dp, sampleRecipe.id)) {
                ProfilePageNew()
                RecipeCard(recipe = sampleRecipe,16.dp)
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
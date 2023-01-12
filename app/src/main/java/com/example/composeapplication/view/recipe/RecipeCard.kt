package com.example.composeapplication.view.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeapplication.data.model.Recipe
import com.example.composeapplication.view.RecipeImage

@Composable
fun RecipeCard(recipe: Recipe, padding: Dp) {
    Card(elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(
                bottom = 4.dp, top = 4.dp,
                end = 4.dp, start = 4.dp
            )
            .layoutId("recipeCard_${recipe.id}")
            .wrapContentHeight()
            .padding(padding)
            ) {
        Column(Modifier.padding(16.dp)) {
            with(recipe) {
                RecipeImage(this)
                Text(text = title, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center)
                for (item in ingredients) {
                    Text(text = ". $item",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start)
                }
            }
        }
    }
}


@Composable
@Preview
fun DefaultRecipeCard() {
    Surface(Modifier.wrapContentSize()) {
        RecipeCard(recipe = sampleRecipe, padding =16.dp)
    }
}

val sampleRecipe = Recipe(null,
    "https://www.uplooder.net/img/image/24/21cdf6f7ded6fb31f77613f15a888938/download-pasta.jpeg",
    "Test Food",
    listOf("Rice","Chicken","Noodles","Mushrooms","Soy Sauce"),10)


val recipeList = listOf<Recipe>(
    Recipe(null,
        "https://www.uplooder.net/img/image/24/21cdf6f7ded6fb31f77613f15a888938/download-pasta.jpeg",
        "Food 1",
        listOf("Loaf","Chicken","Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/82/c5adcb2d0310cd5a9f0717914588515b/download.jpeg",
        "Food 2",
        listOf("Meat","Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/56/1c77105d06fbf84353e9b1f769229d74/meatball-black-bean-chilli-2-bf7378b.jpg",
        "Food 3",
        listOf("Chicken","Noodles","Mushrooms","Soy Sauce"))
)
package com.example.composeapplication.feature.recipe.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeapplication.feature.recipe.domain.model.Recipe
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
        listOf("Chicken","Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/37/43b39fc8e1f965525b711a862fe8d0ef/1699568390870.JPEG",
        "Food 4",
        listOf("Chicken","Meat Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/11/989517e2ebb84baade958484ca73cc0f/1699568390922.JPEG",
        "Food 5",
        listOf("Chicken","Vegetable Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/92/12c8f970075e56864ae7f8dceb448d14/1699568390946.JPEG",
        "Food 6",
        listOf("Chicken","Noodles","Mushrooms","Chilli")),
    Recipe(null,
        "https://www.uplooder.net/img/image/52/b5de389c7805e93337e654d59a5327b1/1699568390973.JPEG",
        "Food 7",
        listOf("Chicken","Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/26/7f823473f251f50b3d9936cbf446ba12/1699568391010.JPEG",
        "Food 8",
        listOf("Chicken","Noodles","Mushrooms","Soy Sauce")),
    Recipe(null,
        "https://www.uplooder.net/img/image/94/aed0a1d57af43a2cc48be68dc1c807d6/1699568391096.JPEG",
        "Food 9",
        listOf("Chicken","Noodles","Mushrooms","Soy Sauce"))
)
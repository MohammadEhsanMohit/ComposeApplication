package com.example.composeapplication.data.model

import androidx.annotation.DrawableRes
import kotlin.random.Random

data class Recipe(
    @DrawableRes val imageResource: Int?=null,
    val imageUrl : String? = null,
    val title: String,
    val ingredients: List<String>,
    val id : Int = Random.nextInt()
)

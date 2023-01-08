package com.example.composeapplication.common

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet

fun mainActivityConstraintSet(margin: Dp, id: Int) = ConstraintSet {
    val profile = createRefFor("profileCard")
    val recipe = createRefFor("recipeCard_$id")


    constrain(profile) {
        top.linkTo(parent.top, 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
    constrain(recipe) {
        top.linkTo(profile.bottom, 4.dp)
        start.linkTo(profile.start)
        end.linkTo(profile.end)
    }
}
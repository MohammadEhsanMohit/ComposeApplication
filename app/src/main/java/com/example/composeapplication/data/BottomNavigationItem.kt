package com.example.composeapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(var title: String, var icon: ImageVector, var screen_route: String) {

    object Profile : BottomNavigationItem("Profile", Icons.Default.Person, "profile")
    object ProfileList : BottomNavigationItem("ProfileList", Icons.Default.AccountBox, "profileList")
    object RecipeList : BottomNavigationItem("RecipeList", Icons.Default.Info, "RecipeList")
}

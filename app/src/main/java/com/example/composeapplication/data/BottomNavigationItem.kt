package com.example.composeapplication.data

import com.example.composeapplication.R

sealed class BottomNavigationItem(var title: String, var icon: Int, var screen_route: String) {

    object Profile : BottomNavigationItem("Profile", R.drawable.icon_profile, "profile")
    object Note : BottomNavigationItem("Note", R.drawable.icon_note, "note")
    object RecipeList : BottomNavigationItem("RecipeList", R.drawable.icon_list, "RecipeList")
}

package com.example.composeapplication.data

import com.example.composeapplication.R

sealed class BottomNavigationItem(var title: String, var icon: Int, var screen_route: String) {

    object Profile : BottomNavigationItem("Profile", R.drawable.icon_profile, "profile")
    object ProfileList : BottomNavigationItem("ProfileList", R.drawable.icon_list, "profileList")
    object RecipeList : BottomNavigationItem("RecipeList", R.drawable.icon_list, "RecipeList")
}

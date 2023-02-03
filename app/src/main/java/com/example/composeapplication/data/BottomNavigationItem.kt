package com.example.composeapplication.data

import com.example.composeapplication.R
import com.example.composeapplication.navigation.RouteConstant.BOTTOM_PROFILE_ROUTE
import com.example.composeapplication.navigation.RouteConstant.BOTTOM_RECIPE_LIST_ROUTE
import com.example.composeapplication.navigation.RouteConstant.NOTE_SCREEN

sealed class BottomNavigationItem(var title: String, var icon: Int, var screen_route: String) {

    object Profile : BottomNavigationItem("Profile", R.drawable.icon_profile, BOTTOM_PROFILE_ROUTE)
    object Note : BottomNavigationItem("Note", R.drawable.icon_note, NOTE_SCREEN)
    object RecipeList : BottomNavigationItem("RecipeList", R.drawable.icon_list, BOTTOM_RECIPE_LIST_ROUTE)
}

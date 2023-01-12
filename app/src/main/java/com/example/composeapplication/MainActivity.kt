package com.example.composeapplication

import BottomBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.data.BottomNavigationItem
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.view.ProfilePage
import com.example.composeapplication.view.ProfilePageNew

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenView()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        ProfilePageNew()
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItem.Profile.screen_route) {
        composable(BottomNavigationItem.Profile.screen_route) {
            ProfilePage()
        }
        composable(BottomNavigationItem.ProfileList.screen_route) {
            ProfilePageNew()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { padding ->
        NavHost(
            navController,
            startDestination = BottomNavigationItem.Profile.screen_route,
            Modifier.padding(padding)
        ) {
            composable(BottomNavigationItem.Profile.screen_route) {
                ProfilePage()
            }
            composable(BottomNavigationItem.ProfileList.screen_route) {
                ProfilePageNew()
            }

        }


    }


}

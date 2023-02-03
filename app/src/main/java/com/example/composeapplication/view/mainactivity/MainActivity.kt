package com.example.composeapplication.view.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.common.view.BurgerMenuScreen
import com.example.composeapplication.feature.splash.presentation.splash.SplashScreenView
import com.example.composeapplication.navigation.SplashToHomeRoute.HomeRoute
import com.example.composeapplication.navigation.SplashToHomeRoute.SplashScreenRoute
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nav = rememberNavController()
            ComposeApplicationTheme {
                Surface {
                    NavHost(
                        navController = nav,
                        startDestination = SplashScreenRoute.route
                    ) {
                        composable(SplashScreenRoute.route) {
                            SplashScreenView(
                                onLoadingDone = {
                                    nav.navigate(HomeRoute.route) {
                                        //clear pop up
                                        popUpTo(SplashScreenRoute.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                        //todo added login and otp screen later
                        composable(HomeRoute.route) {
                            MainActivityCustomView()
                        }
                    }
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    private fun ShowMainHome() {
        ComposeApplicationTheme {
            BurgerMenuScreen()
        }
    }
}

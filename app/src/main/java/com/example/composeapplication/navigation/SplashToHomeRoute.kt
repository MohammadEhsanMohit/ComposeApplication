package com.example.composeapplication.navigation

import androidx.navigation.NavGraphBuilder
import com.example.composeapplication.navigation.RouteConstanceSplashToHome.HOME_MAIN_SCREEN
import com.example.composeapplication.navigation.RouteConstanceSplashToHome.LOGIN_OTP_ROUTE
import com.example.composeapplication.navigation.RouteConstanceSplashToHome.LOGIN_ROUTE
import com.example.composeapplication.navigation.RouteConstanceSplashToHome.SPLASH_ROUTE

object RouteConstanceSplashToHome {
    const val SPLASH_ROUTE = "SplashScreen"
    const val LOGIN_ROUTE = "LoginScreen"
    const val LOGIN_OTP_ROUTE = "LoginScreen"
    const val HOME_MAIN_SCREEN = "main_Screen"
}
sealed class SplashToHomeRoute(val route: String) {
    object SplashScreenRoute : SplashToHomeRoute(SPLASH_ROUTE)
    object LoginScreenRoute : SplashToHomeRoute(LOGIN_ROUTE)
    object LoginOtpScreenRoute : SplashToHomeRoute(LOGIN_OTP_ROUTE)
    object HomeRoute : SplashToHomeRoute(HOME_MAIN_SCREEN)
}
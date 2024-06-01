package com.duyle.navhostkot104

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.duyle.navhostkot104.screen.LoginScreen
import com.duyle.navhostkot104.screen.WelComeScreen

enum class ROUTE_SCREEN_NAME {
    WELCOME,
    LOGIN,
    HOME,
    PROFILE
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ROUTE_SCREEN_NAME.WELCOME.name,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_SCREEN_NAME.WELCOME.name) {
            WelComeScreen(navController)
        }
        composable(ROUTE_SCREEN_NAME.LOGIN.name) {
            LoginScreen(navController = navController)
        }
    }
}
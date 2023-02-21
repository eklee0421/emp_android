package com.lotte.smart.emp.base.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lotte.smart.emp.domain.home.HomeScreen
import com.lotte.smart.emp.domain.login.LoginScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    )
    {
        composable(route = Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
    }
}
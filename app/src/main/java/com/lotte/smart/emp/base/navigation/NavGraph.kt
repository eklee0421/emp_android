package com.lotte.smart.emp.base.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lotte.smart.emp.domain.home.HomeScreen
import com.lotte.smart.emp.domain.launcher.LauncherScreen
import com.lotte.smart.emp.domain.login.LoginScreen
import com.lotte.smart.emp.domain.setting.SettingScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    )
    {
        composable(route = Screens.Launcher.route) {
            LauncherScreen(navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Setting.route) {
            SettingScreen(navController)
        }
    }
}
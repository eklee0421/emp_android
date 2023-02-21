package com.lotte.smart.emp.base.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lotte.smart.emp.domain.home.HomeScreen
import com.lotte.smart.emp.domain.login.LoginScreen
import com.lotte.smart.emp.domain.login.LoginViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    )
    {
        composable(route = Screens.Login.route) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(navController, viewModel)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
    }
}
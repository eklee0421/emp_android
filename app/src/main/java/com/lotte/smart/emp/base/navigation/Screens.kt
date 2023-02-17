package com.lotte.smart.emp.base.navigation

sealed class Screens(val route : String) {
    object Login: Screens("login_screen")
    object Home: Screens("home_screen")
}
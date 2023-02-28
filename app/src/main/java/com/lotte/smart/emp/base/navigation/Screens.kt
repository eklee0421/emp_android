package com.lotte.smart.emp.base.navigation

sealed class Screens(val route: String) {
    object Launcher : Screens("launcher")
    object Login : Screens("login")
    object Home : Screens("home")
    object Setting : Screens("setting")
}
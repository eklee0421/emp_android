package com.lotte.smart.emp.domain.launcher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.base.navigation.Screens

@Composable
fun LauncherScreen(navController: NavController, viewModel: LauncherViewModel = hiltViewModel()) {

    val state = viewModel.state.observeAsState()

    LaunchedEffect(state.value) {
        state.value?.let {
            when (it) {
                is LauncherState.OnChangeHome -> {
                    navController.navigate(Screens.Home.route) {
                        launchSingleTop = true
                    }
                }
                is LauncherState.OnChangeLogin -> {
                    navController.navigate(Screens.Login.route) {
                        launchSingleTop = true
                    }
                }
            }
        }
    }

    LauncherView()
}
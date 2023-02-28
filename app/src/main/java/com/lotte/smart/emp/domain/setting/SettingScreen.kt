package com.lotte.smart.emp.domain.setting

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.base.navigation.Screens

@Composable
fun SettingScreen(navController: NavController, viewModel: SettingViewModel = hiltViewModel()) {
    SettingView()

    val state = viewModel.state.observeAsState()

    LaunchedEffect(state.value) {
        state.value?.let {
            when (it) {
                is SettingState.OnChangeHome -> {
                    navController.navigate(Screens.Home.route) {
                        launchSingleTop = true
                    }
                }

            }
        }
    }
}
package com.lotte.smart.emp.domain.personal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.base.navigation.Screens

@Composable
fun PersonalScreen(navController: NavController, viewModel: PersonalViewModel = hiltViewModel()) {
    PersonalView()

    val state = viewModel.state.observeAsState()

    LaunchedEffect(state.value) {
        state.value?.let {
            when (it) {
                is PersonalState.OnChangeSetting -> {
                    navController.navigate(Screens.Setting.route) {
                        launchSingleTop = true
                    }
                }

            }
        }
    }
}
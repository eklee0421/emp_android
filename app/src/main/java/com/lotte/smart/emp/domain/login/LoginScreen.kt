package com.lotte.smart.emp.domain.login


import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.base.navigation.Screens

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    //view
    LoginView()

    val state = viewModel.state.observeAsState()
    state.value?.let {
        when (it) {
            is LoginState.OnChangeHome -> {
                navController.navigate(Screens.Home.route)
            }
        }
    }

    
}
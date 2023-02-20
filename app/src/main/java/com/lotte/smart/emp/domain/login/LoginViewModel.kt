package com.lotte.smart.emp.domain.login

import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.lotte.smart.emp.base.BaseViewModel
import com.lotte.smart.emp.base.navigation.Screens
import com.lotte.smart.emp.model.LoginModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel() : BaseViewModel() {
    var loginModel = mutableStateOf(LoginModel())
    var isAutoChecked = mutableStateOf(false)

    fun procLogin(navController: NavController) {

        //input 체크
        if (loginModel.value.id.isBlank()) {
            return
        } else if (loginModel.value.password.isBlank()) {
            return
        }

        navController.navigate(Screens.Home.route)

    }

}
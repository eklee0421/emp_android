package com.lotte.smart.emp.domain.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.lotte.smart.emp.base.BaseViewModel
import com.lotte.smart.emp.base.navigation.Screens
import com.lotte.smart.emp.model.LoginModel

class LoginViewModel() : BaseViewModel() {
    var loginModel = mutableStateOf(LoginModel())

    fun procLogin(navController: NavController, loginModel: LoginModel){

        //input 체크
        if(loginModel.id.isBlank()){
            return
        }
        else if(loginModel.password.isBlank()){
            return
        }

        navController.navigate(Screens.Home.route)

    }
    /*fun onChange(newNum: Int) {
        sampleData = sampleData.copy(num1 = newNum)
    }*/
}
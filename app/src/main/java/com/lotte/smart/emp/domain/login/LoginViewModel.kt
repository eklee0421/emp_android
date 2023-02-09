package com.lotte.smart.emp.domain.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lotte.smart.emp.base.BaseViewModel
import com.lotte.smart.emp.model.LoginModel

class LoginViewModel : BaseViewModel() {
    var loginModel = mutableStateOf(LoginModel())

    /*fun onChange(newNum: Int) {
        sampleData = sampleData.copy(num1 = newNum)
    }*/
}
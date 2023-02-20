package com.lotte.smart.emp.domain.login

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.lotte.smart.emp.base.BaseViewModel
import com.lotte.smart.emp.base.navigation.Screens
import com.lotte.smart.emp.model.LoginModel
import com.lotte.smart.emp.repository.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    application: Application
) : BaseViewModel(application) {
    var loginModel = mutableStateOf(LoginModel())
    var isAutoChecked = mutableStateOf(false)

    fun procLogin(navController: NavController) {

        viewModelScope.launch {
            //input 체크
            if (loginModel.value.id.isBlank()) {
                return@launch
            } else if (loginModel.value.password.isBlank()) {
                return@launch
            }

            loginRepository.login(loginModel.value.id, loginModel.value.password)

            navController.navigate(Screens.Home.route)
        }

    }

}
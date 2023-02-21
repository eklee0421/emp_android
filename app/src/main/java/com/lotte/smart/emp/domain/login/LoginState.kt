package com.lotte.smart.emp.domain.login

sealed class LoginState {
    object OnChangeHome : LoginState()
}
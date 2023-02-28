package com.lotte.smart.emp.domain.launcher

sealed class LauncherState {
    object OnChangeHome : LauncherState()
    object OnChangeLogin : LauncherState()
}
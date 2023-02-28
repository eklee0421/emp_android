package com.lotte.smart.emp.domain.setting

sealed class SettingState {
    object OnChangeHome : SettingState()
}
package com.lotte.smart.emp.domain.personal

sealed class PersonalState {
    object OnChangeSetting : PersonalState()
}
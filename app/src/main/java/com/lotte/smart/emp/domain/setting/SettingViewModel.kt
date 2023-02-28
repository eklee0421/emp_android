package com.lotte.smart.emp.domain.setting

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lotte.smart.emp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(

) : BaseViewModel() {

    val isAlarm = mutableStateOf(false)

    val _state = MutableLiveData<SettingState>()
    val state: LiveData<SettingState>
        get() = _state

    fun setState(state: SettingState) {
        _state.postValue(state)
    }

    fun onChangeHome() {
        setState(SettingState.OnChangeHome)
    }

    fun setAlarm() {
        if (isAlarm.value) {
            //todo 알람 수신
        } else {
            //todo 알람 미수신
        }
    }
}
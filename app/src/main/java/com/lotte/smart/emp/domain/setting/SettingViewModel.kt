package com.lotte.smart.emp.domain.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lotte.smart.emp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(

) : BaseViewModel() {

    val _state = MutableLiveData<SettingState>()
    val state: LiveData<SettingState>
        get() = _state

    fun setState(state: SettingState) {
        _state.postValue(state)
    }

    fun onChangeHome() {
        setState(SettingState.OnChangeHome)
    }
}
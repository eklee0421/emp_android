package com.lotte.smart.emp.domain.launcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lotte.smart.emp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(

) : BaseViewModel() {

    val _state = MutableLiveData<LauncherState>()
    val state: LiveData<LauncherState>
        get() = _state

    fun setState(state: LauncherState) {
        _state.postValue(state)
    }

    init {
        //todo 자동 로그인 시 home 화면으로 이동
        setState(LauncherState.OnChangeLogin)
    }
}
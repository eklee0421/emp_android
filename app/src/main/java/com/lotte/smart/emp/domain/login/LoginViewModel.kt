package com.lotte.smart.emp.domain.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lotte.smart.emp.base.BaseViewModel
import com.lotte.smart.emp.model.LoginModel
import com.lotte.smart.emp.repository.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseViewModel() {
    var loginModel = mutableStateOf(LoginModel())
    var isAutoChecked = mutableStateOf(false)

    val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState>
        get() = _state

    fun setState(state: LoginState) {
        _state.postValue(state)
    }

    fun log(){
        Log.e("??","hg==============")
    }

    fun procLogin() {

        viewModelScope.launch {
            //input 체크
            /*if (loginModel.value.id.isBlank()) {
                return@launch
            } else if (loginModel.value.password.isBlank()) {
                return@launch
            }*/

            //loginRepository.login(loginModel.value.id, loginModel.value.password)

            setState(LoginState.OnChangeHome)
        }

    }

}
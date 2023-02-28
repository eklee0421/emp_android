package com.lotte.smart.emp.domain.personal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lotte.smart.emp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonalViewModel @Inject constructor(

) : BaseViewModel() {

    val _state = MutableLiveData<PersonalState>()
    val state: LiveData<PersonalState>
        get() = _state

    fun setState(state: PersonalState) {
        _state.postValue(state)
    }

    fun onChangeSetting() {
        setState(PersonalState.OnChangeSetting)
    }

    
}
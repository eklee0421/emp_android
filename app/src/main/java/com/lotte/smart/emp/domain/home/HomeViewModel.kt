package com.lotte.smart.emp.domain.home

import androidx.lifecycle.MutableLiveData
import com.lotte.smart.emp.base.BaseModel
import com.lotte.smart.emp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    val initHomeIndex = MutableLiveData(BaseModel.getHomeIndex())


}
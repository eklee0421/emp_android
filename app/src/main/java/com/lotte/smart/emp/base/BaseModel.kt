package com.lotte.smart.emp.base

abstract class BaseModel {

    companion object {
        private var homeIndex: Int = 0

        fun setHomeIndex(value: Int) {
            homeIndex = value
        }

        fun getHomeIndex(): Int {
            return homeIndex
        }
    }


}
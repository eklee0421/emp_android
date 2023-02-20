package com.lotte.smart.emp.repository.login

interface LoginRepository {
    suspend fun login(id: String, pw: String)
}
package com.example.fragmentdemo.status

import com.example.fragmentdemo.account.AccountManagerProxy

class LoginStatus private constructor() {
    private var loginStatus: Boolean = false
    companion object {
        val instance: LoginStatus by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LoginStatus() }
    }

    fun getLoginStatue() : Boolean {
        return loginStatus
    }

    fun setLoginStatus(status: Boolean) {
        loginStatus = status
    }

    fun checkLogin(key: String, value: String): Boolean {
        return AccountManagerProxy.instance.isAccountValid(key, value)
    }
}
package com.example.fragmentdemo.account

class AccountManagerProxy : IAccountQuery {
    // Single-instance mode
    companion object {
        val instance: AccountManagerProxy by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AccountManagerProxy()
        }
    }

    override fun isAccountValid(key: String, value: String): Boolean {
        return AccountManager.instance.isAccountValid(key, value)
    }
}
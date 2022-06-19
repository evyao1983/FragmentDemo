package com.example.fragmentdemo.account

import com.example.fragmentdemo.util.AESCrypt
import com.example.fragmentdemo.util.Crypt

class AccountManager : IAccountQuery {
    // Single-instance mode
    companion object {
        val loginInfoMap:HashMap<String,String> = HashMap<String,String>()
        private var plantext = "HSBC"
        private var Token = "HSBC2022HSBC2022"
        private val crypt = Crypt(AESCrypt())
        val instance: AccountManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            // use Room will be better
            preMadeAccount()
            AccountManager()
        }

        private fun preMadeAccount() {
            var encrypt = crypt.encrypt(plantext, Token)
            loginInfoMap["Michale"] = encrypt
            loginInfoMap["Eva"] = encrypt
            loginInfoMap["Test"] = encrypt
        }
    }

    override fun isAccountValid(key: String, value: String): Boolean {
        var encryptedPwd = loginInfoMap[key].toString()
        var pwd = crypt.decrypt(encryptedPwd, Token)
        return value?.equals(pwd)
    }
}
package com.example.fragmentdemo.account

interface IAccountQuery {
    // check account valid or invalid
    fun isAccountValid(key: String, value: String): Boolean
}
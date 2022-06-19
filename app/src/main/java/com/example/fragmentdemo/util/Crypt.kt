package com.example.fragmentdemo.util

class Crypt(strategy: CryptStrategy) {
    var strategy: CryptStrategy

    fun encrypt(input:String, password:String): String {
        return strategy.encrypt(input, password)
    }

    fun decrypt(input:String, password:String): String {
        return strategy.decrypt(input, password)
    }

    init {
        this.strategy = strategy
    }
}
package com.example.fragmentdemo.util

// Strategy mode for encrypt/decrypt
interface CryptStrategy {
    /**
     * 加密算法
     */
    fun encrypt(input:String,password:String): String

    /**
     * 解密算法
     */
    fun decrypt(input: String, password: String): String
}
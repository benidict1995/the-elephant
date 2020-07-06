package com.benidict.domain.gateway

interface AppGateway{
    suspend fun saveFirstInstall(key: String, firstInstall: Boolean): Boolean
    suspend fun isFirstInstall(key: String): Boolean
}
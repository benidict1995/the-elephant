package com.benidict.data.gateway

import com.benidict.data.service.PersistenceService
import com.benidict.domain.gateway.AppGateway

class AppDataGateway(private val persistenceService: PersistenceService): AppGateway{

    override suspend fun saveFirstInstall(key: String, firstInstall: Boolean): Boolean {
        persistenceService.write(key, firstInstall)
        return firstInstall
    }

    override suspend fun isFirstInstall(key: String): Boolean  = persistenceService.readBool(key)

}
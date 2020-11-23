package com.benidict.domain.interactor.app

import com.benidict.domain.gateway.AppGateway

class SaveFirstInstallUseCaseFake(private val appGateway: AppGateway){
    suspend fun invoke(key: String) = appGateway.saveFirstInstall(key, true)
}
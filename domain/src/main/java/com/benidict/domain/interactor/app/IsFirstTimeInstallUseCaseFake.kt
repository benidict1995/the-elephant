package com.benidict.domain.interactor.app

import com.benidict.domain.gateway.AppGateway

class IsFirstTimeInstallUseCaseFake(private val appGateway: AppGateway){

    suspend fun execute(key: String) = appGateway.isFirstInstall(key)

}
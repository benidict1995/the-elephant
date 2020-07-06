package com.benidict.domain.interactor.app

import com.benidict.domain.gateway.AppGateway

class SaveFirstInstallUseCase(private val appGateway: AppGateway){

    suspend fun execute(key: String) = appGateway.saveFirstInstall(key, true)

}
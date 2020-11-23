package com.benidict.mvvm_ktdsl.mockinjection

import com.benidict.data.gateway.mock.AppDataGatewayMock
import com.benidict.domain.gateway.AppGateway
import com.benidict.domain.interactor.app.IsFirstTimeInstallUseCaseFake

class DataGatewayModuleMock(){

    init {
        isFirstTimeInstallUseCase()
    }

    fun isFirstTimeInstallUseCase() = IsFirstTimeInstallUseCaseFake(AppDataGatewayMock() as AppGateway)
}
package com.benidict.domain.interactor.elephantinfo

import com.benidict.domain.gateway.ElephantGateway

class LoadElephantInfoUseCase(private val elephantGateway: ElephantGateway){
    suspend fun execute() = elephantGateway.loadElephantInfo()
}
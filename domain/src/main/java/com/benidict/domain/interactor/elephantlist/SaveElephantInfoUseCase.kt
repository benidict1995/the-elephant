package com.benidict.domain.interactor.elephantlist

import com.benidict.domain.gateway.ElephantGateway
import com.benidict.domain.model.Elephant

class SaveElephantInfoUseCase(private val elephantGateway: ElephantGateway){
    suspend fun execute(elephant: Elephant) = elephantGateway.saveElephantInfo(elephant)
}
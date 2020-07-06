package com.benidict.data.gateway

import com.benidict.domain.exception.apiCall
import com.benidict.data.model.mapper.ElephantMapper
import com.benidict.data.service.PersistenceService
import com.benidict.data.service.RemoteService
import com.benidict.domain.gateway.ElephantGateway
import com.benidict.domain.model.Elephant

class ElephantDataGateway(private val service: RemoteService, private val persistenceService: PersistenceService):
    ElephantGateway {

    override suspend fun loadElephantList(): List<Elephant> = apiCall {
         if (!persistenceService.loadElephantList().isNullOrEmpty()){
                persistenceService.loadElephantList()
            }else{
                ElephantMapper.elephantMapperResponse(service.loadElephantList())
                    .also { data ->
                        persistenceService.saveElephantList(data)
                    }
         }
    }

    override suspend fun saveElephantInfo(elephant: Elephant) = persistenceService.saveElephantInfo(elephant)

    override suspend fun loadElephantInfo(): Elephant = persistenceService.loadElephantInfo()
}
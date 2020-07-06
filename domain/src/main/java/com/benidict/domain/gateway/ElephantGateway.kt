package com.benidict.domain.gateway

import com.benidict.domain.model.Elephant

interface ElephantGateway {
    suspend fun loadElephantList(): List<Elephant>
    suspend fun saveElephantInfo(elephant: Elephant)
    suspend fun loadElephantInfo(): Elephant
}
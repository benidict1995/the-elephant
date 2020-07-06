package com.benidict.domain.interactor.elephantlist

import com.benidict.domain.gateway.ElephantGateway
import com.benidict.domain.model.Elephant
import com.benidict.domain.model.ElephantHeader


class LoadElephantListUseCase(private val elephantGateway: ElephantGateway) {

    suspend fun execute(filter: String): List<ElephantHeader> = addHeader(
        elephantGateway.loadElephantList()
            .filter { it.name.isNotEmpty() && it.name != "null" && it.name.contains(filter, true)}
            .distinct()
            .sortedBy { it.name }
    )

    private fun addHeader(elephants: List<Elephant>): List<ElephantHeader> {
        return elephants
            .map { it.name[0] }
            .distinct()
            .map { header ->
                ElephantHeader(
                    header = header.toString(),
                    elephant = elephants.filter { data -> data.name[0] == header
                    }
                )
            }.toList()
    }

}
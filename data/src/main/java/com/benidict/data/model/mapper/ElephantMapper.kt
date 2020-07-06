package com.benidict.data.model.mapper

import com.benidict.data.model.response.ElephantResponse
import com.benidict.domain.model.Elephant

object ElephantMapper{

    fun elephantMapperResponse(elephantList: List<ElephantResponse>): List<Elephant>
        = elephantList.map { response ->
        Elephant(
            id = response.id,
            index = response.index,
            name = response.name.toString(),
            affiliation = response.affiliation,
            species = response.species,
            sex = response.sex,
            fictional = response.fictional,
            wikilink = response.wikilink,
            image = response.image,
            note = response.note,
            dod =  response.dod,
            dob = response.dob,
            memories = (0..10000).random(),
            followers = (0..10000).random(),
            following = (0..10000).random()
        )
    }.toList()

}
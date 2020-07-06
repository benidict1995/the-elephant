package com.benidict.domain.model


data class Elephant(
    val id: String?= null,
    val index: String?= null,
    val name: String = "",
    val affiliation: String?= null,
    val species: String?= null,
    val sex: String?= null,
    val fictional: Boolean?= null,
    val wikilink: String?= null,
    val image: String?= null,
    val note: String?= null,
    val dob: String?= null,
    val dod: String?= null,
    val memories: Int = 0,
    val followers: Int = 0,
    val following: Int = 0
)
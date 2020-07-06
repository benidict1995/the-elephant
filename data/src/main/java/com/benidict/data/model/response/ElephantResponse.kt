package com.benidict.data.model.response

import com.google.gson.annotations.SerializedName

data class ElephantResponse(
    @SerializedName("_id") val id: String?= null,
    @SerializedName("index") val index: String?= null,
    @SerializedName("name") val name: String?= null,
    @SerializedName("affiliation") val affiliation: String?= null,
    @SerializedName("species") val species: String?= null,
    @SerializedName("sex") val sex: String?= null,
    @SerializedName("fictional") val fictional: Boolean?= null,
    @SerializedName("wikilink") val wikilink: String?= null,
    @SerializedName("image") val image: String?= null,
    @SerializedName("note") val note: String?= null,
    @SerializedName("dob") val dob:String?= null,
    @SerializedName("dod") val dod:String?= null
)
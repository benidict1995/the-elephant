package com.benidict.data.service

import com.benidict.data.model.response.ElephantResponse
import retrofit2.http.GET

interface RemoteService {

    @GET("elephants")
    suspend fun loadElephantList(): List<ElephantResponse>

}
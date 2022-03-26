package com.example.remote.api

import com.example.remote.models.GetFeeRemoteModel
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {

    @GET("/qt-api/Item/fee/{id}?getRelatedData=true")
    suspend fun getFee(@Path("id") feeId: Int): GetFeeRemoteModel

}
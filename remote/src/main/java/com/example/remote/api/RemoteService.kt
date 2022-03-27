package com.example.remote.api

import com.example.remote.models.GetFeeRemoteModel
import com.example.remote.response.GetFeeResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {

    @GET("/qt-api/Item/fee/{id}?getRelatedData=true")
    fun getFee(@Path("id") feeId: Int): Observable<GetFeeResponseModel>

}
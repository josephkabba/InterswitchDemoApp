package com.example.data

import com.example.data.models.GetFeeDataModel
import io.reactivex.Observable

interface RemoteDataSource {
    fun getFeeItem(feeId: Int): Observable<GetFeeDataModel>
}
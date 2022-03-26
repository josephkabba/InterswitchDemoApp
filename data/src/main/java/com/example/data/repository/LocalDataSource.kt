package com.example.data.repository

import com.example.data.models.FeeDataModel
import io.reactivex.Completable
import io.reactivex.Observable

interface LocalDataSource {
    fun insertItemFee(dataItem: FeeDataModel): Completable

    fun getLocalFeeItem(id: Int): Observable<FeeDataModel>

    fun deleteAllFeeData(): Completable
}
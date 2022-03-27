package com.example.data.repository

import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface LocalDataSource {
    fun insertItemFee(dataItem: FeeDataModel): Completable

    fun getLocalFeeItem(id: Int): Observable<FeeDataModel>

    fun deleteAllFeeData(): Completable

    fun getCacheItemCount(): Observable<Int>

    fun insertItemFeeGroups(parent: Int, dataItem: List<FeeGroupDataModel>): Completable

    fun insertItemPayConfigs(parent: Int, dataItem: List<PayConfigurationDataModel>): Completable
}
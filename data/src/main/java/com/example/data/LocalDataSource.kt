package com.example.data

import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface LocalDataSource {
    fun insertItemFee(dataItem: FeeDataModel)

    fun getLocalFeeItem(id: Int): FeeDataModel?

    fun deleteAllFeeData()

    fun getCacheItemCount(): Observable<Int>

    fun insertItemFeeGroups(parent: Int, dataItem: List<FeeGroupDataModel>)

    fun insertItemPayConfigs(parent: Int, dataItem: List<PayConfigurationDataModel>)
}
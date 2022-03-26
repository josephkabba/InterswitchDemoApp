package com.example.data

import com.example.data.models.FeeDataModel

interface LocalDataSource {
    fun insertItemFee(dataItem: FeeDataModel)

    suspend fun getLocalFeeItem(id: Int): FeeDataModel

    fun deleteAllFeeData()
}
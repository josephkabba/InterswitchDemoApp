package com.example.data.repository

import com.example.data.models.FeeDataModel

interface LocalDataSource {
    fun insertItemFee(dataItem: FeeDataModel)

    suspend fun getLocalFeeItem(id: Int): FeeDataModel

    suspend fun deleteAllFeeData()
}
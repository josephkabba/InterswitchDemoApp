package com.example.data

import com.example.data.models.GetFeeDataModel

interface RemoteDataSource {
    suspend fun getFeeItem(feeId: Int): GetFeeDataModel
}
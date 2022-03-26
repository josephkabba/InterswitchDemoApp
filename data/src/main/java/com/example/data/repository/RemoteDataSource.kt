package com.example.data.repository

import com.example.data.models.GetFeeDataModel

interface RemoteDataSource {
    suspend fun getFeeItem(feeId: Int): GetFeeDataModel
}
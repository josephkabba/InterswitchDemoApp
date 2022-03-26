package com.example.local

import com.example.data.models.FeeDataModel
import com.example.data.repository.LocalDataSource
import com.example.local.database.AppDataBase
import com.example.local.mappers.FeeLocalMapper
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val database: AppDataBase,
    private val feeLocalMapper: FeeLocalMapper
): LocalDataSource {
    override fun insertItemFee(dataItem: FeeDataModel) {
        database.feeDao().insertItemFee(feeLocalMapper.toLocal(dataItem))
    }

    override suspend fun getLocalFeeItem(id: Int): FeeDataModel {
        return feeLocalMapper.toData(database.feeDao().getLocalFeeItem(id))
    }

    override suspend fun deleteAllFeeData() {
        database.feeDao().deleteAllFeeData()
    }

}
package com.example.local

import com.example.data.models.FeeDataModel
import com.example.data.repository.LocalDataSource
import com.example.local.database.AppDataBase
import com.example.local.mappers.FeeLocalMapper
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val database: AppDataBase,
    private val feeLocalMapper: FeeLocalMapper
): LocalDataSource {
    override fun insertItemFee(dataItem: FeeDataModel): Completable {
        return database.feeDao().insertItemFee(feeLocalMapper.toLocal(dataItem))
    }

    override fun getLocalFeeItem(id: Int): Observable<FeeDataModel> {
        return database.feeDao().getLocalFeeItem(id).map {
            feeLocalMapper.toData(it)
        }
    }

    override fun deleteAllFeeData(): Completable {
       return database.feeDao().deleteAllFeeData()
    }

}
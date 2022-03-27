package com.example.local

import android.util.Log
import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import com.example.data.repository.LocalDataSource
import com.example.local.database.AppDataBase
import com.example.local.mappers.FeeLocalMapper
import com.example.local.models.relationships.toFeeDataModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Function
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
            it.toFeeDataModel()
        }
    }

    override fun deleteAllFeeData(): Completable {
       return database.feeDao().deleteAllFeeData()
    }

    override fun getCacheItemCount(): Observable<Int> {
        return database.feeDao().getCacheItemCount()
    }

    override fun insertItemFeeGroups(parent: Int, dataItem: List<FeeGroupDataModel>): Completable {
        return database.feeDao().insertItemFeeGroups(dataItem.map { feeLocalMapper.toFeeGroupLocalModel(parent, it) })
    }

    override fun insertItemPayConfigs(parent: Int, dataItem: List<PayConfigurationDataModel>): Completable {
        return database.feeDao().insertItemPayConfigs(dataItem.map { feeLocalMapper.toPayConfigLocal(parent, it) })
    }

}
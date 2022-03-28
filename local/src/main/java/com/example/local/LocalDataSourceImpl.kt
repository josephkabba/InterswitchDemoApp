package com.example.local

import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import com.example.data.LocalDataSource
import com.example.local.database.AppDataBase
import com.example.local.mappers.FeeLocalMapper
import com.example.local.models.relationships.toFeeDataModel
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.concurrent.Executors
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val database: AppDataBase,
    private val feeLocalMapper: FeeLocalMapper
): LocalDataSource {
    override fun insertItemFee(dataItem: FeeDataModel) {
        return database.feeDao().insertItemFee(feeLocalMapper.toLocal(dataItem))
    }

    override fun getLocalFeeItem(id: Int): FeeDataModel? {
        return database.feeDao().getLocalFeeItem(id)?.toFeeDataModel()
    }

    override fun deleteAllFeeData() {
       database.feeDao().deleteAllFeeData()
    }

    override fun getCacheItemCount(): Observable<Int> {
        return database.feeDao().getCacheItemCount()
    }

    override fun insertItemFeeGroups(parent: Int, dataItem: List<FeeGroupDataModel>) {
        return database.feeDao().insertItemFeeGroups(dataItem.map { feeLocalMapper.toFeeGroupLocalModel(parent, it) })
    }

    override fun insertItemPayConfigs(parent: Int, dataItem: List<PayConfigurationDataModel>){
        return database.feeDao().insertItemPayConfigs(dataItem.map { feeLocalMapper.toPayConfigLocal(parent, it) })
    }

}
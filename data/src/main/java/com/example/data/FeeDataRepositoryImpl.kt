package com.example.data

import com.example.data.mappers.FeeDataMapper
import com.example.data.models.toFeeDataModel
import com.example.data.repository.LocalDataSource
import com.example.data.repository.RemoteDataSource
import com.example.domain.models.FeeDomainModel
import com.example.domain.repository.FeeDataRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class FeeDataRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val feeDataMapper: FeeDataMapper
) : FeeDataRepository {
    override fun getFeeData(id: Int): Observable<FeeDomainModel> {
        val dataObservable = localDataSource.getLocalFeeItem(id)
            .map {
                feeDataMapper.toDomain(it)
            }

        return remoteDataSource.getFeeItem(id).map {
            localDataSource.insertItemFee(it.toFeeDataModel())
            localDataSource.insertItemFeeGroups(
                it.toFeeDataModel().id,
                it.toFeeDataModel().feeGroups
            )
            localDataSource.insertItemPayConfigs(
                it.toFeeDataModel().id,
                it.toFeeDataModel().payConfiguration
            )
            feeDataMapper.toDomain(it.toFeeDataModel())
        }.concatWith(dataObservable)

    }

    override fun deleteCache(): Completable {
        return localDataSource.deleteAllFeeData()
    }

    override fun getCacheItemCount(): Observable<Int> {
        return localDataSource.getCacheItemCount()
    }
}
package com.example.data

import com.example.data.mappers.FeeDataMapper
import com.example.data.models.isEmpty
import com.example.data.models.toFeeDataModel
import com.example.data.repository.LocalDataSource
import com.example.data.repository.RemoteDataSource
import com.example.domain.models.FeeDomainModel
import com.example.domain.repository.FeeDataRepository
import javax.inject.Inject

class FeeDataRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val feeDataMapper: FeeDataMapper
): FeeDataRepository {
    override suspend fun getFeeData(id: Int): FeeDomainModel {
        var data = localDataSource.getLocalFeeItem(id)

        if (data.isEmpty()){
            data = remoteDataSource.getFeeItem(id).toFeeDataModel()
            localDataSource.insertItemFee(data)
        }

        return feeDataMapper.toDomain(data)
    }

    override suspend fun deleteCache() {
        localDataSource.deleteAllFeeData()
    }
}
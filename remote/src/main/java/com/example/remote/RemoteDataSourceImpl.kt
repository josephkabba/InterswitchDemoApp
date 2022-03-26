package com.example.remote

import com.example.data.repository.RemoteDataSource
import com.example.data.models.GetFeeDataModel
import com.example.remote.api.RemoteService
import com.example.remote.mappers.GetFeeRemoteResponseMapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val getFeeRemoteResponseMapper: GetFeeRemoteResponseMapper
): RemoteDataSource {
    override suspend fun getFeeItem(feeId: Int): GetFeeDataModel {
        return getFeeRemoteResponseMapper.toData(remoteService.getFee(feeId))
    }

}
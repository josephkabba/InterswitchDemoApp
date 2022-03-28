package com.example.remote

import com.example.data.RemoteDataSource
import com.example.data.models.GetFeeDataModel
import com.example.remote.api.RemoteService
import com.example.remote.mappers.GetFeeRemoteResponseMapper
import com.example.remote.response.toGetFeeRemoteModel
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val getFeeRemoteResponseMapper: GetFeeRemoteResponseMapper
): RemoteDataSource {
    override fun getFeeItem(feeId: Int): Observable<GetFeeDataModel> {
        return remoteService.getFee(feeId).map { response ->
            getFeeRemoteResponseMapper.toData(response.toGetFeeRemoteModel())
        }
    }
}
package com.example.remote.mappers

import com.example.data.models.GetFeeDataModel
import com.example.remote.models.GetFeeRemoteModel
import javax.inject.Inject

class GetFeeRemoteResponseMapper @Inject constructor(
    private val feeRemoteResponseMapper: FeeRemoteResponseMapper
) : BaseRemoteMapper<GetFeeRemoteModel, GetFeeDataModel> {
    override fun toRemote(d: GetFeeDataModel): GetFeeRemoteModel {
        return GetFeeRemoteModel(
            response = feeRemoteResponseMapper.toRemote(d.response),
            responseCode = d.responseCode,
            responseMessage = d.responseMessage
        )
    }

    override fun toData(r: GetFeeRemoteModel): GetFeeDataModel {
        return GetFeeDataModel(
            response = feeRemoteResponseMapper.toData(r.response),
            responseCode = r.responseCode,
            responseMessage = r.responseMessage
        )
    }
}
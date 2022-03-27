package com.example.remote.response

import com.example.data.models.GetFeeDataModel
import com.example.remote.models.GetFeeRemoteModel

data class GetFeeResponseModel(
    val response: FeeResponseModel,
    val responseCode: Int,
    val responseMessage: String
)

fun GetFeeResponseModel.toGetFeeRemoteModel(): GetFeeRemoteModel {
    return GetFeeRemoteModel(
        responseMessage = this.responseMessage,
        responseCode = this.responseCode,
        response = this.response.toFeeRemoteModel()
    )
}
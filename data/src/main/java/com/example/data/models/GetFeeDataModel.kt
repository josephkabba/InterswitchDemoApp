package com.example.data.models

data class GetFeeDataModel(
    val response: FeeDataModel,
    val responseCode: Int,
    val responseMessage: String
)

fun GetFeeDataModel.toFeeDataModel(): FeeDataModel {
    return this.response
}

package com.example.remote.models

data class GetFeeRemoteModel(
    val response: FeeRemoteModel,
    val responseCode: Int,
    val responseMessage: String
)
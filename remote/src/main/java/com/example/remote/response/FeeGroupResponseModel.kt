package com.example.remote.response

import com.example.remote.models.FeeGroupRemoteModel

data class FeeGroupResponseModel(
    val clientFees: Any?,
    val description: String?,
    val id: Int?,
    val isActive: Boolean?,
    val issueDate: String?,
    val item: Any?,
    val itemFeeId: Int?,
    val itemId: Int?,
    val name: String?
)

fun FeeGroupResponseModel.toFeeGroupRemoteModel(): FeeGroupRemoteModel {
    return FeeGroupRemoteModel(
        clientFees = this.clientFees ?: "",
        description = this.description ?: "",
        id = this.id ?: 0,
        isActive = this.isActive ?: false,
        issueDate = this.issueDate ?: "",
        item = this.item ?: "",
        itemFeeId = this.itemFeeId ?: 0,
        itemId = this.itemId ?: 0,
        name = this.name ?: ""
    )
}

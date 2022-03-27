package com.example.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.models.FeeGroupDataModel
import com.example.local.CommonLocal

@Entity(tableName = CommonLocal.fee_group_data)
data class FeeGroupLocalModel(

    @PrimaryKey
    val id: Int,


    val foreignId: Int? = null,

    val description: String,
    val isActive: Boolean,
    val issueDate: String,
    val itemFeeId: Int,
    val itemId: Int,
    val name: String
)

fun FeeGroupLocalModel.toFeeGroupDataModel(): FeeGroupDataModel {
    return FeeGroupDataModel(
        id = this.id,
        clientFees = "",
        description = this.description,
        isActive = this.isActive,
        issueDate = this.issueDate,
        item = "",
        itemFeeId = this.itemFeeId,
        itemId = this.itemId,
        name = this.name
    )
}

package com.example.local.mappers

import com.example.data.models.FeeGroupDataModel
import com.example.local.models.FeeGroupLocalModel
import javax.inject.Inject

class FeeGroupLocalMapper @Inject constructor():
    BaseLocalMapper<FeeGroupLocalModel, FeeGroupDataModel> {
    override fun toLocal(data: FeeGroupDataModel): FeeGroupLocalModel {
        return FeeGroupLocalModel(
            clientFees = data.clientFees,
            description = data.description,
            id = data.id,
            isActive = data.isActive,
            issueDate = data.issueDate,
            item = data.item,
            itemFeeId = data.itemFeeId,
            itemId = data.itemId,
            name = data.name
        )
    }

    override fun toData(local: FeeGroupLocalModel): FeeGroupDataModel {
        return FeeGroupDataModel(
            clientFees = local.clientFees,
            description = local.description,
            id = local.id,
            isActive = local.isActive,
            issueDate = local.issueDate,
            item = local.item,
            itemFeeId = local.itemFeeId,
            itemId = local.itemId,
            name = local.name
        )
    }
}
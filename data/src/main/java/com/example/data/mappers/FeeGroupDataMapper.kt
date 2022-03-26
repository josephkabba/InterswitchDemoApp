package com.example.data.mappers

import com.example.data.models.FeeGroupDataModel
import com.example.domain.models.FeeGroupDomainModel
import javax.inject.Inject

class FeeGroupDataMapper @Inject constructor() :
    BaseDataMapper<FeeGroupDataModel, FeeGroupDomainModel> {
    override fun toDomain(t: FeeGroupDataModel): FeeGroupDomainModel {
        return FeeGroupDomainModel(
            clientFees = t.clientFees,
            description = t.description,
            id = t.id,
            isActive = t.isActive,
            issueDate = t.issueDate,
            item = t.item,
            itemFeeId = t.itemFeeId,
            itemId = t.itemId,
            name = t.name
        )
    }

    override fun toData(e: FeeGroupDomainModel): FeeGroupDataModel {
        return FeeGroupDataModel(
            clientFees = e.clientFees,
            description = e.description,
            id = e.id,
            isActive = e.isActive,
            issueDate = e.issueDate,
            item = e.item,
            itemFeeId = e.itemFeeId,
            itemId = e.itemId,
            name = e.name
        )
    }
}
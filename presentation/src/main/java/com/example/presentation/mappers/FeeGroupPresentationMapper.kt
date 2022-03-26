package com.example.presentation.mappers

import com.example.domain.models.FeeGroupDomainModel
import com.example.presentation.models.FeeGroupPresentationModel
import javax.inject.Inject

class FeeGroupPresentationMapper @Inject constructor() :
    BasePresentationMapper<FeeGroupPresentationModel, FeeGroupDomainModel> {
    override fun toDomain(t: FeeGroupPresentationModel): FeeGroupDomainModel {
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

    override fun toPresentation(e: FeeGroupDomainModel): FeeGroupPresentationModel {
        return FeeGroupPresentationModel(
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
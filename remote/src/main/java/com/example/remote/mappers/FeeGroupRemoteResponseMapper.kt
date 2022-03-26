package com.example.remote.mappers

import com.example.data.models.FeeGroupDataModel
import com.example.remote.models.FeeGroupRemoteModel

class FeeGroupRemoteResponseMapper :
    BaseRemoteMapper<FeeGroupRemoteModel, FeeGroupDataModel> {
    override fun toRemote(d: FeeGroupDataModel): FeeGroupRemoteModel {
        return FeeGroupRemoteModel(
            clientFees = d.clientFees,
            description = d.description,
            id = d.id,
            isActive = d.isActive,
            issueDate = d.issueDate,
            item = d.item,
            itemFeeId = d.itemFeeId,
            itemId = d.itemId,
            name = d.name
        )
    }

    override fun toData(r: FeeGroupRemoteModel): FeeGroupDataModel {
        return FeeGroupDataModel(
            clientFees = r.clientFees,
            description = r.description,
            id = r.id,
            isActive = r.isActive,
            issueDate = r.issueDate,
            item = r.item,
            itemFeeId = r.itemFeeId,
            itemId = r.itemId,
            name = r.name
        )
    }
}
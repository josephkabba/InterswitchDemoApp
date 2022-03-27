package com.example.local.models.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import com.example.local.models.*

data class FeeLocalRelation(
    @Embedded val feeLocalModel: FeeLocalModel,

    @Relation(
        parentColumn = "id",
        entityColumn = "foreignId"
    )
    val feeGroups: List<FeeGroupLocalModel>,

    @Relation(
        parentColumn = "id",
        entityColumn = "foreignId"
    )
    val payConfig: List<PayConfigurationLocalModel>
)

fun FeeLocalRelation.toFeeDataModel(): FeeDataModel {
    return FeeDataModel(
        excise = this.feeLocalModel.excise,
        exciseTaxAccount = this.feeLocalModel.exciseTaxAccount,
        feeGroups = feeGroups.map { it.toFeeGroupDataModel() },
        hasProviderServiceCharge = this.feeLocalModel.hasProviderServiceCharge,
        id = this.feeLocalModel.id,
        isActive = this.feeLocalModel.isActive,
        isInclusiveInAmount = this.feeLocalModel.isInclusiveInAmount,
        issueDate = this.feeLocalModel.issueDate,
        name = this.feeLocalModel.name,
        overrideBillerFee = this.feeLocalModel.overrideBillerFee,
        payConfiguration = this.payConfig.map { it.toPayConfigurationDataModal() },
        providerServiceCharge = this.feeLocalModel.providerServiceCharge,
        providerServiceChargeAccount = this.feeLocalModel.providerServiceChargeAccount,
        taxAccount = this.feeLocalModel.exciseTaxAccount,
        vat = this.feeLocalModel.excise,
        withholdingTax = this.feeLocalModel.excise,
        withholdingTaxAccount = this.feeLocalModel.withholdingTaxAccount,
    )
}


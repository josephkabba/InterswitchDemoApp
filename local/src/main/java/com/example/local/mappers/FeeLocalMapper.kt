package com.example.local.mappers

import com.example.data.models.FeeDataModel
import com.example.data.models.FeeGroupDataModel
import com.example.data.models.PayConfigurationDataModel
import com.example.local.models.*
import javax.inject.Inject

class FeeLocalMapper @Inject constructor() {
    fun toLocal(data: FeeDataModel): FeeLocalModel {
        return FeeLocalModel(
            excise = data.excise,
            exciseTaxAccount = data.exciseTaxAccount,
            hasProviderServiceCharge = data.hasProviderServiceCharge,
            id = data.id,
            isActive = data.isActive,
            isInclusiveInAmount = data.isInclusiveInAmount,
            issueDate = data.issueDate,
            name = data.name,
            overrideBillerFee = data.overrideBillerFee,
            providerServiceCharge = data.providerServiceCharge,
            providerServiceChargeAccount = data.providerServiceChargeAccount,
            taxAccount = data.taxAccount,
            vat = data.vat,
            withholdingTax = data.withholdingTax,
            withholdingTaxAccount = data.withholdingTaxAccount
        )
    }

    fun toData(
        local: FeeLocalModel,
        feeGroups: List<FeeGroupDataModel>,
        payConfigurationDataModel: List<PayConfigurationDataModel>
    ): FeeDataModel {
        return FeeDataModel(
            excise = local.excise,
            exciseTaxAccount = local.exciseTaxAccount,
            feeGroups = feeGroups,
            hasProviderServiceCharge = local.hasProviderServiceCharge,
            id = local.id,
            isActive = local.isActive,
            isInclusiveInAmount = local.isInclusiveInAmount,
            issueDate = local.issueDate,
            name = local.name,
            overrideBillerFee = local.overrideBillerFee,
            payConfiguration = payConfigurationDataModel,
            providerServiceCharge = local.providerServiceCharge,
            providerServiceChargeAccount = local.providerServiceChargeAccount,
            taxAccount = local.taxAccount,
            vat = local.vat,
            withholdingTax = local.withholdingTax,
            withholdingTaxAccount = local.withholdingTaxAccount
        )
    }

    fun toPayConfigLocal(parent: Int, p: PayConfigurationDataModel): PayConfigurationLocalModel {
        return PayConfigurationLocalModel(
            foreignId = parent,
            bandCode = p .bandCode,
            hasExcise = p.hasExcise,
            hasServiceCharge = p.hasServiceCharge,
            hasWithholdingTax = p.hasWithholdingTax,
            isPayVAT = p.isPayVAT,
            itemFeeMapSettingId = p.itemFeeMapSettingId,
            maximumFeeBorn = p.maximumFeeBorn,
            minimumFeeBorn = p.minimumFeeBorn,
            payType = p.payType,
            payValue = p.payValue,
            source = p.source
        )
    }

    fun toFeeGroupLocalModel(parent: Int, f: FeeGroupDataModel): FeeGroupLocalModel {
        return FeeGroupLocalModel(
            foreignId = parent,
            id = f.id,
            description = f.description,
            isActive = f.isActive,
            issueDate = f.issueDate,
            itemFeeId = f.itemFeeId,
            itemId = f.itemId,
            name = f.name
        )
    }
}
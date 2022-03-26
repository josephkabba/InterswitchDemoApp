package com.example.local.mappers

import com.example.data.models.FeeDataModel
import com.example.local.models.FeeLocalModel
import javax.inject.Inject

class FeeLocalMapper @Inject constructor(
    private val feeGroupLocalMapper: FeeGroupLocalMapper,
    private val payConfigurationLocalMapper: PayConfigurationLocalMapper
) : BaseLocalMapper<FeeLocalModel, FeeDataModel> {
    override fun toLocal(data: FeeDataModel): FeeLocalModel{
        return FeeLocalModel(
            excise = data.excise,
            exciseTaxAccount = data.exciseTaxAccount,
            feeGroups = data.feeGroups.map { feeGroupLocalMapper.toLocal(it) },
            hasProviderServiceCharge = data.hasProviderServiceCharge,
            id = data.id,
            isActive = data.isActive,
            isInclusiveInAmount = data.isInclusiveInAmount,
            issueDate = data.issueDate,
            itemFeeMapSettings = data.itemFeeMapSettings,
            name = data.name,
            overrideBillerFee = data.overrideBillerFee,
            payConfiguration = data.payConfiguration.map { payConfigurationLocalMapper.toLocal(it) },
            providerServiceCharge = data.providerServiceCharge,
            providerServiceChargeAccount = data.providerServiceChargeAccount,
            taxAccount = data.taxAccount,
            vat = data.vat,
            withholdingTax = data.withholdingTax,
            withholdingTaxAccount = data.withholdingTaxAccount
        )
    }

    override fun toData(local: FeeLocalModel): FeeDataModel {
        return FeeDataModel(
            excise = local.excise,
            exciseTaxAccount = local.exciseTaxAccount,
            feeGroups = local.feeGroups.map { feeGroupLocalMapper.toData(it) },
            hasProviderServiceCharge = local.hasProviderServiceCharge,
            id = local.id,
            isActive = local.isActive,
            isInclusiveInAmount = local.isInclusiveInAmount,
            issueDate = local.issueDate,
            itemFeeMapSettings = local.itemFeeMapSettings,
            name = local.name,
            overrideBillerFee = local.overrideBillerFee,
            payConfiguration = local.payConfiguration.map { payConfigurationLocalMapper.toData(it) },
            providerServiceCharge = local.providerServiceCharge,
            providerServiceChargeAccount = local.providerServiceChargeAccount,
            taxAccount = local.taxAccount,
            vat = local.vat,
            withholdingTax = local.withholdingTax,
            withholdingTaxAccount = local.withholdingTaxAccount
        )
    }
}
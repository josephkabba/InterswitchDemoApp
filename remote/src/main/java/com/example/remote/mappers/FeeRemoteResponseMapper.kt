package com.example.remote.mappers

import com.example.data.models.FeeDataModel
import com.example.remote.models.FeeRemoteModel
import javax.inject.Inject

class FeeRemoteResponseMapper @Inject constructor(
    private val feeGroupRemoteResponseMapper: FeeGroupRemoteResponseMapper,
    private val payConfigurationRemoteResponseMapper: PayConfigurationRemoteResponseMapper
) : BaseRemoteMapper<FeeRemoteModel, FeeDataModel> {
    override fun toRemote(d: FeeDataModel): FeeRemoteModel{
        return FeeRemoteModel(
            excise = d.excise,
            exciseTaxAccount = d.exciseTaxAccount,
            feeGroups = d.feeGroups.map { feeGroupRemoteResponseMapper.toRemote(it) },
            hasProviderServiceCharge = d.hasProviderServiceCharge,
            id = d.id,
            isActive = d.isActive,
            isInclusiveInAmount = d.isInclusiveInAmount,
            issueDate = d.issueDate,
            itemFeeMapSettings = d.itemFeeMapSettings,
            name = d.name,
            overrideBillerFee = d.overrideBillerFee,
            payConfiguration = d.payConfiguration.map { payConfigurationRemoteResponseMapper.toRemote(it) },
            providerServiceCharge = d.providerServiceCharge,
            providerServiceChargeAccount = d.providerServiceChargeAccount,
            taxAccount = d.taxAccount,
            vat = d.vat,
            withholdingTax = d.withholdingTax,
            withholdingTaxAccount = d.withholdingTaxAccount
        )
    }

    override fun toData(r: FeeRemoteModel): FeeDataModel {
        return FeeDataModel(
            excise = r.excise,
            exciseTaxAccount = r.exciseTaxAccount,
            feeGroups = r.feeGroups.map { feeGroupRemoteResponseMapper.toData(it) },
            hasProviderServiceCharge = r.hasProviderServiceCharge,
            id = r.id,
            isActive = r.isActive,
            isInclusiveInAmount = r.isInclusiveInAmount,
            issueDate = r.issueDate,
            itemFeeMapSettings = r.itemFeeMapSettings,
            name = r.name,
            overrideBillerFee = r.overrideBillerFee,
            payConfiguration = r.payConfiguration.map { payConfigurationRemoteResponseMapper.toData(it) },
            providerServiceCharge = r.providerServiceCharge,
            providerServiceChargeAccount = r.providerServiceChargeAccount,
            taxAccount = r.taxAccount,
            vat = r.vat,
            withholdingTax = r.withholdingTax,
            withholdingTaxAccount = r.withholdingTaxAccount
        )
    }
}
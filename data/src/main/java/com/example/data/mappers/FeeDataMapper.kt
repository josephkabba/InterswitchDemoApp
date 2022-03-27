package com.example.data.mappers

import com.example.data.models.FeeDataModel
import com.example.domain.models.FeeDomainModel
import javax.inject.Inject

class FeeDataMapper @Inject constructor(
    private val feeGroupDataMapper: FeeGroupDataMapper,
    private val payConfigurationDataMapper: PayConfigurationDataMapper
) : BaseDataMapper<FeeDataModel, FeeDomainModel> {
    override fun toDomain(t: FeeDataModel): FeeDomainModel{
        return FeeDomainModel(
            excise = t.excise,
            exciseTaxAccount = t.exciseTaxAccount,
            feeGroups = t.feeGroups.map { feeGroupDataMapper.toDomain(it) },
            hasProviderServiceCharge = t.hasProviderServiceCharge,
            id = t.id,
            isActive = t.isActive,
            isInclusiveInAmount = t.isInclusiveInAmount,
            issueDate = t.issueDate,
            name = t.name,
            overrideBillerFee = t.overrideBillerFee,
            payConfiguration = t.payConfiguration.map { payConfigurationDataMapper.toDomain(it) },
            providerServiceCharge = t.providerServiceCharge,
            providerServiceChargeAccount = t.providerServiceChargeAccount,
            taxAccount = t.taxAccount,
            vat = t.vat,
            withholdingTax = t.withholdingTax,
            withholdingTaxAccount = t.withholdingTaxAccount
        )
    }

    override fun toData(e: FeeDomainModel): FeeDataModel {
        return FeeDataModel(
            excise = e.excise,
            exciseTaxAccount = e.exciseTaxAccount,
            feeGroups = e.feeGroups.map { feeGroupDataMapper.toData(it) },
            hasProviderServiceCharge = e.hasProviderServiceCharge,
            id = e.id,
            isActive = e.isActive,
            isInclusiveInAmount = e.isInclusiveInAmount,
            issueDate = e.issueDate,
            name = e.name,
            overrideBillerFee = e.overrideBillerFee,
            payConfiguration = e.payConfiguration.map { payConfigurationDataMapper.toData(it) },
            providerServiceCharge = e.providerServiceCharge,
            providerServiceChargeAccount = e.providerServiceChargeAccount,
            taxAccount = e.taxAccount,
            vat = e.vat,
            withholdingTax = e.withholdingTax,
            withholdingTaxAccount = e.withholdingTaxAccount
        )
    }
}
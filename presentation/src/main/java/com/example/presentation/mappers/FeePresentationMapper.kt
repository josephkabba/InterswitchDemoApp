package com.example.presentation.mappers

import com.example.domain.models.FeeDomainModel
import com.example.presentation.models.FeePresentationModel
import javax.inject.Inject

class FeePresentationMapper @Inject constructor(
    private val feeGroupPresentationMapper: FeeGroupPresentationMapper,
    private val payConfigurationPresentationMapper: PayConfigurationPresentationMapper
) : BasePresentationMapper<FeePresentationModel, FeeDomainModel> {
    override fun toDomain(t: FeePresentationModel): FeeDomainModel{
        return FeeDomainModel(
            excise = t.excise,
            exciseTaxAccount = t.exciseTaxAccount,
            feeGroups = t.feeGroups.map { feeGroupPresentationMapper.toDomain(it) },
            hasProviderServiceCharge = t.hasProviderServiceCharge,
            id = t.id,
            isActive = t.isActive,
            isInclusiveInAmount = t.isInclusiveInAmount,
            issueDate = t.issueDate,
            itemFeeMapSettings = t.itemFeeMapSettings,
            name = t.name,
            overrideBillerFee = t.overrideBillerFee,
            payConfiguration = t.payConfiguration.map { payConfigurationPresentationMapper.toDomain(it) },
            providerServiceCharge = t.providerServiceCharge,
            providerServiceChargeAccount = t.providerServiceChargeAccount,
            taxAccount = t.taxAccount,
            vat = t.vat,
            withholdingTax = t.withholdingTax,
            withholdingTaxAccount = t.withholdingTaxAccount
        )
    }

    override fun toPresentation(e: FeeDomainModel): FeePresentationModel {
        return FeePresentationModel(
            excise = e.excise,
            exciseTaxAccount = e.exciseTaxAccount,
            feeGroups = e.feeGroups.map { feeGroupPresentationMapper.toPresentation(it) },
            hasProviderServiceCharge = e.hasProviderServiceCharge,
            id = e.id,
            isActive = e.isActive,
            isInclusiveInAmount = e.isInclusiveInAmount,
            issueDate = e.issueDate,
            itemFeeMapSettings = e.itemFeeMapSettings,
            name = e.name,
            overrideBillerFee = e.overrideBillerFee,
            payConfiguration = e.payConfiguration.map { payConfigurationPresentationMapper.toPresentation(it) },
            providerServiceCharge = e.providerServiceCharge,
            providerServiceChargeAccount = e.providerServiceChargeAccount,
            taxAccount = e.taxAccount,
            vat = e.vat,
            withholdingTax = e.withholdingTax,
            withholdingTaxAccount = e.withholdingTaxAccount
        )
    }
}
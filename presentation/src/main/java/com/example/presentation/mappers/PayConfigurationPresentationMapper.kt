package com.example.presentation.mappers

import com.example.domain.models.PayConfigurationDomainModel
import com.example.presentation.models.PayConfigurationPresentationModel
import javax.inject.Inject

class PayConfigurationPresentationMapper @Inject constructor() :
    BasePresentationMapper<PayConfigurationPresentationModel, PayConfigurationDomainModel> {
    override fun toDomain(t: PayConfigurationPresentationModel): PayConfigurationDomainModel {
        return PayConfigurationDomainModel(
            bandCode = t.bandCode,
            hasExcise = t.hasExcise,
            hasServiceCharge = t.hasServiceCharge,
            hasWithholdingTax = t.hasWithholdingTax,
            isPayVAT = t.isPayVAT,
            itemFeeMapSettingId = t.itemFeeMapSettingId,
            maximumFeeBorn = t.maximumFeeBorn,
            minimumFeeBorn = t.minimumFeeBorn,
            payType = t.payType,
            payValue = t.payValue,
            source = t.source
        )
    }

    override fun toPresentation(e: PayConfigurationDomainModel): PayConfigurationPresentationModel {
        return PayConfigurationPresentationModel(
            bandCode = e.bandCode,
            hasExcise = e.hasExcise,
            hasServiceCharge = e.hasServiceCharge,
            hasWithholdingTax = e.hasWithholdingTax,
            isPayVAT = e.isPayVAT,
            itemFeeMapSettingId = e.itemFeeMapSettingId,
            maximumFeeBorn = e.maximumFeeBorn,
            minimumFeeBorn = e.minimumFeeBorn,
            payType = e.payType,
            payValue = e.payValue,
            source = e.source
        )
    }
}
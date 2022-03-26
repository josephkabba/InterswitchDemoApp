package com.example.data.mappers

import com.example.data.models.PayConfigurationDataModel
import com.example.domain.models.PayConfigurationDomainModel
import javax.inject.Inject

class PayConfigurationDataMapper @Inject constructor() :
    BaseDataMapper<PayConfigurationDataModel, PayConfigurationDomainModel> {
    override fun toDomain(t: PayConfigurationDataModel): PayConfigurationDomainModel {
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

    override fun toData(e: PayConfigurationDomainModel): PayConfigurationDataModel {
        return PayConfigurationDataModel(
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
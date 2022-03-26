package com.example.local.mappers

import com.example.data.models.PayConfigurationDataModel
import com.example.local.models.PayConfigurationLocalModel
import javax.inject.Inject

class PayConfigurationLocalMapper @Inject constructor() :
    BaseLocalMapper<PayConfigurationLocalModel, PayConfigurationDataModel> {
    override fun toLocal(data: PayConfigurationDataModel): PayConfigurationLocalModel {
        return PayConfigurationLocalModel(
            bandCode = data.bandCode,
            hasExcise = data.hasExcise,
            hasServiceCharge = data.hasServiceCharge,
            hasWithholdingTax = data.hasWithholdingTax,
            isPayVAT = data.isPayVAT,
            itemFeeMapSettingId = data.itemFeeMapSettingId,
            maximumFeeBorn = data.maximumFeeBorn,
            minimumFeeBorn = data.minimumFeeBorn,
            payType = data.payType,
            payValue = data.payValue,
            source = data.source
        )
    }

    override fun toData(local: PayConfigurationLocalModel): PayConfigurationDataModel {
        return PayConfigurationDataModel(
            bandCode = local.bandCode,
            hasExcise = local.hasExcise,
            hasServiceCharge = local.hasServiceCharge,
            hasWithholdingTax = local.hasWithholdingTax,
            isPayVAT = local.isPayVAT,
            itemFeeMapSettingId = local.itemFeeMapSettingId,
            maximumFeeBorn = local.maximumFeeBorn,
            minimumFeeBorn = local.minimumFeeBorn,
            payType = local.payType,
            payValue = local.payValue,
            source = local.source
        )
    }
}
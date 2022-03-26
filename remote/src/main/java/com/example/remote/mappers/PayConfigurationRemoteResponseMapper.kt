package com.example.remote.mappers

import com.example.data.models.PayConfigurationDataModel
import com.example.remote.models.PayConfigurationRemoteModel
import javax.inject.Inject

class PayConfigurationRemoteResponseMapper @Inject constructor() :
    BaseRemoteMapper<PayConfigurationRemoteModel, PayConfigurationDataModel> {
    override fun toRemote(d: PayConfigurationDataModel): PayConfigurationRemoteModel {
        return PayConfigurationRemoteModel(
            bandCode = d.bandCode,
            hasExcise = d.hasExcise,
            hasServiceCharge = d.hasServiceCharge,
            hasWithholdingTax = d.hasWithholdingTax,
            isPayVAT = d.isPayVAT,
            itemFeeMapSettingId = d.itemFeeMapSettingId,
            maximumFeeBorn = d.maximumFeeBorn,
            minimumFeeBorn = d.minimumFeeBorn,
            payType = d.payType,
            payValue = d.payValue,
            source = d.source
        )
    }

    override fun toData(r: PayConfigurationRemoteModel): PayConfigurationDataModel {
        return PayConfigurationDataModel(
            bandCode = r.bandCode,
            hasExcise = r.hasExcise,
            hasServiceCharge = r.hasServiceCharge,
            hasWithholdingTax = r.hasWithholdingTax,
            isPayVAT = r.isPayVAT,
            itemFeeMapSettingId = r.itemFeeMapSettingId,
            maximumFeeBorn = r.maximumFeeBorn,
            minimumFeeBorn = r.minimumFeeBorn,
            payType = r.payType,
            payValue = r.payValue,
            source = r.source
        )
    }
}
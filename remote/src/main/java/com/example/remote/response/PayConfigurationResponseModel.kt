package com.example.remote.response

import com.example.remote.models.PayConfigurationRemoteModel

data class PayConfigurationResponseModel(
    val bandCode: String?,
    val hasExcise: Boolean?,
    val hasServiceCharge: Boolean?,
    val hasWithholdingTax: Boolean?,
    val isPayVAT: Boolean?,
    val itemFeeMapSettingId: Int?,
    val maximumFeeBorn: Double?,
    val minimumFeeBorn: Double?,
    val payType: String?,
    val payValue: Double?,
    val source: String?
)

fun PayConfigurationResponseModel.toPayConfigurationRemoteModel(): PayConfigurationRemoteModel {
    return PayConfigurationRemoteModel(
        bandCode = this.bandCode ?: "",
        hasExcise = this.hasExcise ?: false,
        hasServiceCharge = this.hasServiceCharge ?: false,
        hasWithholdingTax = this.hasWithholdingTax ?: false,
        isPayVAT = this.isPayVAT ?: false,
        itemFeeMapSettingId = this.itemFeeMapSettingId ?: 0,
        maximumFeeBorn = this.maximumFeeBorn ?: 0.0,
        minimumFeeBorn = this.minimumFeeBorn ?: 0.0,
        payType = this.payType ?: "",
        payValue = this.payValue ?: 0.0,
        source = this.source ?: ""
    )
}

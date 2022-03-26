package com.example.domain.models

data class PayConfigurationDomainModel(
    val bandCode: String,
    val hasExcise: Boolean,
    val hasServiceCharge: Boolean,
    val hasWithholdingTax: Boolean,
    val isPayVAT: Boolean,
    val itemFeeMapSettingId: Int,
    val maximumFeeBorn: Double,
    val minimumFeeBorn: Double,
    val payType: String,
    val payValue: Double,
    val source: String
)

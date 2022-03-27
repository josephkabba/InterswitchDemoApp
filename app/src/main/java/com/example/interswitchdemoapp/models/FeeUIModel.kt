package com.example.interswitchdemoapp.models


data class FeeUIModel(
    val id: Int,
    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupUIModel>,
    val hasProviderServiceCharge: Boolean,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationUIModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

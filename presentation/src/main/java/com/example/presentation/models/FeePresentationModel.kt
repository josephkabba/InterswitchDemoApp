package com.example.presentation.models


data class FeePresentationModel(
    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupPresentationModel>,
    val hasProviderServiceCharge: Boolean,
    val id: Int,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationPresentationModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

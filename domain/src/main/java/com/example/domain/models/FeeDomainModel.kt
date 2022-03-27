package com.example.domain.models


data class FeeDomainModel(
    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupDomainModel>,
    val hasProviderServiceCharge: Boolean,
    val id: Int,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationDomainModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

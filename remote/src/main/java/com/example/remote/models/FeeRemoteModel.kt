package com.example.remote.models


data class FeeRemoteModel(
    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupRemoteModel>,
    val hasProviderServiceCharge: Boolean,
    val id: Int,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val itemFeeMapSettings: List<Any>,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationRemoteModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

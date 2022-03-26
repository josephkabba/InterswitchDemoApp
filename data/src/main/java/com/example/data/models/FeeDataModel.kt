package com.example.data.models


data class FeeDataModel(
    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupDataModel>,
    val hasProviderServiceCharge: Boolean,
    val id: Int,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val itemFeeMapSettings: List<Any>,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationDataModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

fun FeeDataModel.isEmpty(): Boolean {
    return this.name == ""
}

package com.example.remote.response

import com.example.remote.models.FeeGroupRemoteModel
import com.example.remote.models.FeeRemoteModel
import com.example.remote.models.PayConfigurationRemoteModel


data class FeeResponseModel(
    val excise: Double?,
    val exciseTaxAccount: String?,
    val feeGroups: List<FeeGroupResponseModel>?,
    val hasProviderServiceCharge: Boolean?,
    val id: Int?,
    val isActive: Boolean?,
    val isInclusiveInAmount: Boolean?,
    val issueDate: String?,
    val itemFeeMapSettings: List<Any>?,
    val name: String?,
    val overrideBillerFee: Boolean?,
    val payConfiguration: List<PayConfigurationResponseModel>?,
    val providerServiceCharge: Double?,
    val providerServiceChargeAccount: String?,
    val taxAccount: String?,
    val vat: Double?,
    val withholdingTax: Double?,
    val withholdingTaxAccount: String?
)

fun FeeResponseModel.toFeeRemoteModel(): FeeRemoteModel {
    return FeeRemoteModel(
        excise = this.excise ?: 0.0,
    exciseTaxAccount = this.exciseTaxAccount ?: "",
    feeGroups = (this.feeGroups?.map { it.toFeeGroupRemoteModel() } ?: listOf()),
    hasProviderServiceCharge = this.hasProviderServiceCharge ?: false,
    id = this.id ?: 0,
    isActive = this.isActive ?: false,
    isInclusiveInAmount = this.isInclusiveInAmount ?: false,
    issueDate = this.issueDate ?: "",
    name = this.name ?: "",
    overrideBillerFee = this.overrideBillerFee ?: false,
    payConfiguration = (this.payConfiguration?.map { it.toPayConfigurationRemoteModel() } ?: listOf()),
    providerServiceCharge = this.providerServiceCharge ?: 0.0,
    providerServiceChargeAccount = this.providerServiceChargeAccount ?: "",
    taxAccount = this.taxAccount ?: "",
    vat = this.vat ?: 0.0,
    withholdingTax = this.withholdingTax ?: 0.0,
    withholdingTaxAccount = this.withholdingTaxAccount ?: ""
    )
}

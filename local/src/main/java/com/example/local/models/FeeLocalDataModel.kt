package com.example.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.local.CommonLocal


@Entity(tableName = CommonLocal.table_name)
data class FeeLocalDataModel(

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val excise: Double,
    val exciseTaxAccount: String,
    val feeGroups: List<FeeGroupLocalDataModel>,
    val hasProviderServiceCharge: Boolean,
    val isActive: Boolean,
    val isInclusiveInAmount: Boolean,
    val issueDate: String,
    val itemFeeMapSettings: List<Any>,
    val name: String,
    val overrideBillerFee: Boolean,
    val payConfiguration: List<PayConfigurationLocalDataModel>,
    val providerServiceCharge: Double,
    val providerServiceChargeAccount: String,
    val taxAccount: String,
    val vat: Double,
    val withholdingTax: Double,
    val withholdingTaxAccount: String
)

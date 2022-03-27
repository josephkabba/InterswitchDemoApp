package com.example.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.models.PayConfigurationDataModel
import com.example.local.CommonLocal

@Entity(tableName = CommonLocal.fee_pay_data)
data class PayConfigurationLocalModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val foreignId: Int? = null,

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

fun PayConfigurationLocalModel.toPayConfigurationDataModal(): PayConfigurationDataModel {
    return PayConfigurationDataModel(
        bandCode = this.bandCode,
        hasExcise = this.hasExcise,
        hasServiceCharge = this.hasServiceCharge,
        hasWithholdingTax = this.hasWithholdingTax,
        isPayVAT = this.isPayVAT,
        itemFeeMapSettingId = this.itemFeeMapSettingId,
        maximumFeeBorn = this.maximumFeeBorn,
        minimumFeeBorn = this.minimumFeeBorn,
        payType = this.payType,
        payValue = this.payValue,
        source = this.source
    )
}

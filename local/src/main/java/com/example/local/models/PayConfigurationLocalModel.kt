package com.example.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.local.CommonLocal


@Entity(tableName = CommonLocal.fee_pay_data)
data class PayConfigurationLocalModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

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

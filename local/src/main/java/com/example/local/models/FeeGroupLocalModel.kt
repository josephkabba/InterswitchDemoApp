package com.example.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.local.CommonLocal

@Entity(tableName = CommonLocal.fee_group_data)
data class FeeGroupLocalModel(
    @PrimaryKey
    val id: Int,

    val clientFees: Any,
    val description: String,
    val isActive: Boolean,
    val issueDate: String,
    val item: Any,
    val itemFeeId: Int,
    val itemId: Int,
    val name: String
)

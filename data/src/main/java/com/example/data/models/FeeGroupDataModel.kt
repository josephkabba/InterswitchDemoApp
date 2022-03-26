package com.example.data.models

data class FeeGroupDataModel(
    val clientFees: Any,
    val description: String,
    val id: Int,
    val isActive: Boolean,
    val issueDate: String,
    val item: Any,
    val itemFeeId: Int,
    val itemId: Int,
    val name: String
)

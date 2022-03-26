package com.example.interswitchdemoapp.models

data class FeeGroupUIModel(
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

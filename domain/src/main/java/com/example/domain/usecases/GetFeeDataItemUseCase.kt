package com.example.domain.usecases

import com.example.domain.models.FeeDomainModel
import com.example.domain.repository.FeeDataRepository
import javax.inject.Inject

class GetFeeDataItemUseCase @Inject constructor(
    private val feeDataRepository: FeeDataRepository
) {

    suspend fun getFeeData(id: Int): FeeDomainModel {
        return feeDataRepository.getFeeData(id)
    }
}
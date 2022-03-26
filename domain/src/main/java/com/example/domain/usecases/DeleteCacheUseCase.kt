package com.example.domain.usecases

import com.example.domain.repository.FeeDataRepository
import javax.inject.Inject

class DeleteCacheUseCase @Inject constructor(
    private val feeDataRepository: FeeDataRepository
) {
    suspend fun deleteCache() = feeDataRepository.deleteCache()
}
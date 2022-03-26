package com.example.domain.usecases

import com.example.domain.qualifiers.Background
import com.example.domain.qualifiers.Foreground
import com.example.domain.repository.FeeDataRepository
import com.example.domain.usecases.base.CompletableUseCase
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

class DeleteCacheUseCase @Inject constructor(
    private val feeDataRepository: FeeDataRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) : CompletableUseCase(backgroundScheduler, foregroundScheduler) {

    override fun generateCompletable(): Completable {
        return feeDataRepository.deleteCache()
    }

}
package com.example.domain.usecases.base

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase constructor(
) {
    protected abstract fun generateCompletable()

    fun buildUseCase() {
        return generateCompletable()
    }

}
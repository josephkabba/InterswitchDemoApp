package com.example.domain.usecases.base

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase constructor(
    private val backgroundScheduler: Scheduler,
    private val foregroundScheduler: Scheduler
) {
    protected abstract fun generateCompletable(): Completable

    fun buildUseCase(): Completable {
        return generateCompletable()
            .subscribeOn(backgroundScheduler)
            .observeOn(foregroundScheduler)
    }

}
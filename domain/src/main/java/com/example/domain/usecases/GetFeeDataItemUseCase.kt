package com.example.domain.usecases

import com.example.domain.models.FeeDomainModel
import com.example.domain.qualifiers.Background
import com.example.domain.qualifiers.Foreground
import com.example.domain.repository.FeeDataRepository
import com.example.domain.usecases.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class GetFeeDataItemUseCase @Inject constructor(
    private val feeDataRepository: FeeDataRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler,
) : ObservableUseCase<FeeDomainModel, Int>(backgroundScheduler, foregroundScheduler) {
    override fun generateObservable(input: Int): Observable<FeeDomainModel> {
        return feeDataRepository.getFeeData(input)
    }


}
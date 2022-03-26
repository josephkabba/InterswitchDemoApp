package com.example.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.example.domain.usecases.GetFeeDataItemUseCase
import com.example.presentation.Resource
import com.example.presentation.mappers.FeePresentationMapper
import com.example.presentation.models.FeePresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFeeDataItemUseCase: GetFeeDataItemUseCase,
    private val feePresentationMapper: FeePresentationMapper
) : ViewModel() {

    fun getFeeDataResource(id: Int): LiveData<Resource<FeePresentationModel>> =
        getFeeDataItemUseCase.buildUseCase(id).map { feePresentationMapper.toPresentation(it) }
            .map { Resource.success(it) }.startWith(
                Resource.loading()
            ).onErrorResumeNext(Function { throwable ->
                Observable.just(Resource.error(throwable.localizedMessage))
            }).toFlowable(BackpressureStrategy.LATEST).toLiveData()
}
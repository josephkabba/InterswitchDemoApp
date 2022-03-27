package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.DeleteCacheUseCase
import com.example.domain.usecases.GetCacheItemCountUseCase
import com.example.presentation.models.FeePresentationModel
import com.example.presentation.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.functions.Function

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val deleteCacheUseCase: DeleteCacheUseCase,
    private val getCacheItemCountUseCase: GetCacheItemCountUseCase
) : ViewModel() {

    fun deleteCache() = deleteCacheUseCase.buildUseCase()

    val cacheItemCount =
        getCacheItemCountUseCase.buildUseCase(-1)
            .map { Resource.success(it) }.startWith(
                Resource.loading()
            ).onErrorResumeNext(Function { throwable ->
                Observable.just(Resource.error(throwable.localizedMessage))
            })
}
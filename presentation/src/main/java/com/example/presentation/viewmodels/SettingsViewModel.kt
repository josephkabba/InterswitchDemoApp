package com.example.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.DeleteCacheUseCase
import com.example.presentation.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val deleteCacheUseCase: DeleteCacheUseCase
) : ViewModel() {

    fun deleteCache() = deleteCacheUseCase.buildUseCase()
}
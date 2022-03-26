package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.DeleteCacheUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val deleteCacheUseCase: DeleteCacheUseCase
): ViewModel() {

    fun deleteCache(){
        viewModelScope.launch {
            deleteCacheUseCase.deleteCache()
        }
    }
}
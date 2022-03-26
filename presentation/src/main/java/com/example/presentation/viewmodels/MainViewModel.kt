package com.example.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetFeeDataItemUseCase
import com.example.presentation.mappers.FeePresentationMapper
import com.example.presentation.models.FeePresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFeeDataItemUseCase: GetFeeDataItemUseCase,
    private val feePresentationMapper: FeePresentationMapper
): ViewModel() {

    private val data = MutableLiveData<FeePresentationModel>()

    fun getFeeDataItem(id: Int): LiveData<FeePresentationModel> {

        viewModelScope.launch {
            data.value = feePresentationMapper.toPresentation(getFeeDataItemUseCase.getFeeData(id))
        }

        return data
    }
}
package com.example.interswitchdemoapp.state_holders

import android.content.res.Resources
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.presentation.Resource
import com.example.presentation.models.FeePresentationModel
import com.example.presentation.viewmodels.MainViewModel
import io.reactivex.disposables.Disposable

class MainScreenStateHolder(
    private val viewModel: MainViewModel,
    val navController: NavController,
    private val resources: Resources,
) {

    var searchText by mutableStateOf("")
    var disposable: Disposable? = null

    fun search(id: String) {
        if (id.isNotEmpty() or id.isNotBlank()){

        }
    }

}
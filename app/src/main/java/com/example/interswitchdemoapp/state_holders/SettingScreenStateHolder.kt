package com.example.interswitchdemoapp.state_holders

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.presentation.models.Status
import com.example.presentation.viewmodels.SettingsViewModel
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope

class SettingScreenStateHolder(
    val scaffoldState: ScaffoldState,
    val coroutineScope: CoroutineScope,
    private val viewModel: SettingsViewModel,
    val navController: NavController,
    private val resources: Resources,
) {

    private var disposable: Disposable? = null

    var message by mutableStateOf("")

    fun clearCacheData() {

        disposable = viewModel.cacheItemCount.subscribe { response ->
            when (response.status) {
                Status.ERROR -> {
                    disposable?.dispose()
                    message = "An error occurred"
                }

                Status.LOADING -> {
                    disposable?.dispose()
                    message = "Checking local cache size"
                }

                Status.SUCCESS -> {
                    disposable?.dispose()
                    message = if (response.data == 0) {
                        "Local cache is empty"
                    } else {
                        //viewModel.deleteCache()
                        "Local cache data has been deleted"
                    }
                }
            }


        }
    }

    suspend fun showSnackBar(message: String) {
        scaffoldState.snackbarHostState.showSnackbar(message)
    }
}
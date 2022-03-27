package com.example.interswitchdemoapp.state_holders

import android.content.res.Resources
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.presentation.models.Status
import com.example.presentation.viewmodels.MainViewModel
import io.reactivex.disposables.Disposable

class MainScreenStateHolder(
    private val viewModel: MainViewModel,
    val navController: NavController,
    private val resources: Resources,
    val lifecycleOwner: LifecycleOwner
) {

    var searchText by mutableStateOf("")

    var data by mutableStateOf("""""")

    var loading by mutableStateOf(false)

    var error by mutableStateOf("")

    private var disposable: Disposable? = null


    fun search(id: String) {
        if ((id.isNotEmpty() or id.isNotBlank()) and id.isDigitsOnly()){
            try {
                disposable = viewModel.getFeeDataResource(id.trim().toInt()).subscribe{ response ->
                    when (response.status) {
                        Status.ERROR -> {
                            disposable?.dispose()
                            loading = false
                            error = response.errors.toString()
                        }

                        Status.LOADING -> {
                            disposable?.dispose()
                            error = ""
                            loading = true
                        }

                        Status.SUCCESS -> {
                            disposable?.dispose()
                            error = ""
                            loading = false
                            data = """
id = ${response.data?.id}
excise = ${response.data?.excise}
exciseTaxAccount = ${response.data?.exciseTaxAccount}
hasProviderServiceCharge = ${response.data?.hasProviderServiceCharge}
isActive = ${response.data?.isActive}
isInclusiveInAmount = ${response.data?.isInclusiveInAmount}
issueDate = ${response.data?.issueDate}
name = ${response.data?.name}
overrideBillerFee = ${response.data?.overrideBillerFee}
providerServiceCharge = ${response.data?.providerServiceCharge}
providerServiceChargeAccount = ${response.data?.providerServiceChargeAccount}
taxAccount = ${response.data?.taxAccount}
vat = ${response.data?.vat}
withholdingTax = ${response.data?.withholdingTax}
withholdingTaxAccount: = ${response.data?.withholdingTaxAccount}
                                
feeGroups: ${response.data?.feeGroups?.map { 
     """
                                        
     clientFees = ${it.clientFees}
     description = ${it.description}
     id = ${it.id}
     isActive = ${it.isActive}
     issueDate = ${it.issueDate}
     item = ${it.item}
     itemFeeId = ${it.itemFeeId}
     itemId = ${it.itemId}
     name = ${it.name}
     """
}},
                                
payConfiguration: ${response.data?.payConfiguration?.map {
    """
                                        
    bandCode = ${it.bandCode}
    hasExcise = ${it.hasExcise}
    hasServiceCharge = ${it.hasServiceCharge}
    hasWithholdingTax = ${it.hasWithholdingTax}
    isPayVAT = ${it.isPayVAT}
    itemFeeMapSettingId = ${it.itemFeeMapSettingId}
    maximumFeeBorn = ${it.maximumFeeBorn}
    minimumFeeBorn = ${it.minimumFeeBorn}
    payType = ${it.payType}
    payValue = ${it.payValue}
    source = ${it.source}
    """
}}
""".trimMargin()
                        }
                    }
                }
            }catch (exception: NumberFormatException){

            }

        }
    }

}
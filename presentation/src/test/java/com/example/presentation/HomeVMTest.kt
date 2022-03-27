package com.example.presentation

import com.example.domain.models.FeeDomainModel
import com.example.domain.repository.FeeDataRepository
import com.example.domain.usecases.GetFeeDataItemUseCase
import com.example.presentation.mappers.FeeGroupPresentationMapper
import com.example.presentation.mappers.FeePresentationMapper
import com.example.presentation.mappers.PayConfigurationPresentationMapper
import com.example.presentation.models.Status
import com.example.presentation.viewmodels.MainViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(JUnit4::class)
class HomeVMTest {

    val data = FeeDomainModel(
        excise = 0.0,
        exciseTaxAccount = "",
        feeGroups =  listOf(),
        hasProviderServiceCharge = false,
        id = 0,
        isActive = false,
        isInclusiveInAmount = false,
        issueDate = "",
        name = "",
        overrideBillerFee = false,
        payConfiguration = listOf(),
        providerServiceCharge = 0.0,
        providerServiceChargeAccount = "",
        taxAccount = "",
        vat = 0.0,
        withholdingTax = 0.0,
        withholdingTaxAccount = ""
    )

    @Mock
    private lateinit var repository: FeeDataRepository

    private val payConfigurationPresentationMapper: PayConfigurationPresentationMapper = PayConfigurationPresentationMapper()
    private val feeGroupPresentationMapper: FeeGroupPresentationMapper = FeeGroupPresentationMapper()
    private val feePresenterMapper: FeePresentationMapper = FeePresentationMapper(feeGroupPresentationMapper, payConfigurationPresentationMapper)
    private lateinit var getFeeDataItemUseCase: GetFeeDataItemUseCase

    private lateinit var homeVM: MainViewModel

    private var disposable: Disposable? = null


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        getFeeDataItemUseCase = GetFeeDataItemUseCase(
            repository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )

        homeVM = MainViewModel(
            getFeeDataItemUseCase,
            feePresenterMapper
        )
    }

    @Test
    fun test_getFeeItem_success() {

        Mockito.`when`(repository.getFeeData(0))
            .thenReturn(Observable.just(data))

        val resource = homeVM.getFeeDataResource(0)


        disposable = resource.subscribe { response ->
            when (response.status) {
                Status.ERROR -> {
                    disposable?.dispose()
                }

                Status.LOADING -> {
                    disposable?.dispose()
                }

                Status.SUCCESS -> {
                    disposable?.dispose()

                    assertTrue(true)
                }
            }
        }
    }

    @Test
    fun test_getFeeItem_error() {
        val errorMsg = "Error fetching data"

        Mockito.`when`(repository.getFeeData(0))
            .thenReturn(Observable.error(Throwable(errorMsg)))

        val resource = homeVM.getFeeDataResource(0)

        disposable = resource.subscribe { response ->
            when (response.status) {
                Status.ERROR -> {
                    disposable?.dispose()
                    assertTrue(true)
                }

                Status.LOADING -> {
                    disposable?.dispose()
                }

                Status.SUCCESS -> {
                    disposable?.dispose()
                }
            }
        }
    }

}
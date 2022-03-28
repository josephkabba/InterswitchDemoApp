package com.example.data.repository

import com.example.data.mappers.FeeDataMapper
import com.example.data.models.toFeeDataModel
import com.example.data.LocalDataSource
import com.example.data.RemoteDataSource
import com.example.data.models.FeeDataModel
import com.example.data.models.GetFeeDataModel
import com.example.domain.models.FeeDomainModel
import com.example.domain.repository.FeeDataRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.Function
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import javax.inject.Inject

class FeeDataRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val feeDataMapper: FeeDataMapper,
    private val executor: ExecutorService,
) : FeeDataRepository {

    override fun getFeeData(id: Int): Observable<FeeDomainModel> {
        fun getLocalItems(): FeeDataModel? {
            val callable = Callable<FeeDataModel> { localDataSource.getLocalFeeItem(id) }
            return executor.submit(callable).get()
        }

        val localData = getLocalItems()

        if (localData != null){
            return Observable.just(feeDataMapper.toDomain(localData))
        }

        fun saveFeeDataModel(data: GetFeeDataModel){
            val run = Runnable {
                localDataSource.insertItemFee(data.toFeeDataModel())
                val id = data.toFeeDataModel().id

                localDataSource.insertItemFeeGroups(id, data.response.feeGroups)
                localDataSource.insertItemPayConfigs(id, data.response.payConfiguration)

            }

            executor.submit(run)
        }

        return remoteDataSource.getFeeItem(id).map {
            saveFeeDataModel(it)
            feeDataMapper.toDomain(it.toFeeDataModel())
        }


//        return remoteDataSource.getFeeItem(id).onErrorResumeNext(Function {
//            val data = getLocalItems()
//
//            if (data != null){
//                return@Function  Observable.just(GetFeeDataModel(response =  data, responseCode = 200, responseMessage = ""))
//            }
//
//            throw it
//        }).map {
//            saveFeeDataModel(it)
//            feeDataMapper.toDomain(it.toFeeDataModel())
//        }

    }

    override fun deleteCache() {
        localDataSource.deleteAllFeeData()
    }

    override fun getCacheItemCount(): Observable<Int> {
        return localDataSource.getCacheItemCount()
    }
}
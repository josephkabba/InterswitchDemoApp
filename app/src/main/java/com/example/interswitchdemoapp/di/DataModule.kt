package com.example.interswitchdemoapp.di

import com.example.data.FeeDataRepositoryImpl
import com.example.data.repository.LocalDataSource
import com.example.data.repository.RemoteDataSource
import com.example.domain.repository.FeeDataRepository
import com.example.local.LocalDataSourceImpl
import com.example.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindsLocalDataSource(
        localDataSource: LocalDataSourceImpl
    ): LocalDataSource

    @Singleton
    @Binds
    abstract fun bindsFeeDataSource(
        feeDataSource: FeeDataRepositoryImpl
    ): FeeDataRepository
}
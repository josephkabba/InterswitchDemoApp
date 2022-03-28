package com.example.interswitchdemoapp.di

import com.example.data.repository.FeeDataRepositoryImpl
import com.example.data.LocalDataSource
import com.example.domain.repository.FeeDataRepository
import com.example.local.LocalDataSourceImpl
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
package com.example.interswitchdemoapp.di

import android.content.Context
import com.example.local.database.AppDataBase
import com.example.local.database.FeeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object LocalModule {
    @Singleton
    @Provides
    fun providesAppDatabase(
        @ApplicationContext applicationContext: Context
    ) = AppDataBase.getInstance(applicationContext)

    @Singleton
    @Provides
    fun provideFeeDao(database: AppDataBase): FeeDao {
        return database.feeDao()
    }

    @Singleton
    @Provides
    fun providesExecutorService(): ExecutorService{
        return  Executors.newFixedThreadPool(10)
    }
}
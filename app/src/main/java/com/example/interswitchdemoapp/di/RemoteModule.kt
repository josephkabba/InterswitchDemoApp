package com.example.interswitchdemoapp.di

import com.example.data.repository.RemoteDataSource
import com.example.remote.RemoteDataSourceImpl
import com.example.remote.api.RemoteService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://iswapigateway-develop.azurewebsites.net/"

@InstallIn(SingletonComponent::class)
@Module
class RemoteModule {

    @InstallIn(SingletonComponent::class)
    @Module
    interface Binders {
        @Binds
        fun bindsRemoteDataSource(
            remoteDataSource: RemoteDataSourceImpl
        ): RemoteDataSource
    }

    @Provides
    @Singleton
    fun providesRemoteFeeService(retrofit: Retrofit): RemoteService {
        return retrofit.create(RemoteService::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit {

        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logger)

        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
    }
}
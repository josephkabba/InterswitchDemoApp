package com.example.domain.repository

import com.example.domain.models.FeeDomainModel

interface FeeDataRepository {

    suspend fun getFeeData(id: Int): FeeDomainModel

    suspend fun deleteCache()

}
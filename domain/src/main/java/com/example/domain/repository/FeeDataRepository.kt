package com.example.domain.repository

import com.example.domain.models.FeeDomainModel
import io.reactivex.Completable
import io.reactivex.Observable

interface FeeDataRepository {

    fun getFeeData(id: Int): Observable<FeeDomainModel>

    fun deleteCache(): Completable

}
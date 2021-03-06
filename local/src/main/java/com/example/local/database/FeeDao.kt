package com.example.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.local.models.FeeGroupLocalModel
import com.example.local.models.FeeLocalModel
import com.example.local.models.PayConfigurationLocalModel
import com.example.local.models.relationships.FeeLocalRelation
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface FeeDao {

    @Insert()
    fun insertItemFee(dataItem: FeeLocalModel)

    @Insert()
    fun insertItemFeeGroups(dataItem: List<FeeGroupLocalModel>)

    @Insert()
    fun insertItemPayConfigs(dataItem: List<PayConfigurationLocalModel>)

    @Transaction
    @Query("SELECT * FROM fee_item_data WHERE id=:id LIMIT 1")
    fun getLocalFeeItem(id: Int): FeeLocalRelation?

    @Query("SELECT COUNT(*) FROM fee_item_data")
    fun getCacheItemCount(): Observable<Int>

    @Query("DELETE FROM fee_item_data")
    fun  deleteAllFeeData()
}
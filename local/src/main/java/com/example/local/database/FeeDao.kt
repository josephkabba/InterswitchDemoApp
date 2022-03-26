package com.example.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.local.models.FeeLocalModel
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface FeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemFee(dataItem: FeeLocalModel): Completable

    @Query("SELECT * FROM fee_item_data WHERE id LIKE :id LIMIT 1")
    fun getLocalFeeItem(id: Int): Observable<FeeLocalModel>

    @Query("DELETE FROM fee_item_data")
    fun  deleteAllFeeData(): Completable
}
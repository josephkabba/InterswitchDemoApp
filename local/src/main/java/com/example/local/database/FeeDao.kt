package com.example.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.local.models.FeeLocalModel

@Dao
interface FeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemFee(dataItem: FeeLocalModel)

    @Query("SELECT * FROM fee_item_data WHERE id LIKE :id LIMIT 1")
    suspend fun getLocalFeeItem(id: Int): FeeLocalModel

    @Query("DELETE FROM fee_item_data")
    fun  deleteAllFeeData()
}
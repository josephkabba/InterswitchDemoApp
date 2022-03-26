package com.example.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.local.models.FeeLocalDataModel

@Dao
interface FeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemFee(dataItem: FeeLocalDataModel)

    @Query("SELECT * FROM fee_item_data WHERE id LIKE :id LIMIT 1")
    suspend fun getLocalFeeItem(id: Int): FeeLocalDataModel

    @Query("DELETE FROM fee_item_data")
    fun  deleteAllFeeData()
}
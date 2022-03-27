package com.example.local.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.local.CommonLocal
import com.example.local.models.FeeGroupLocalModel
import com.example.local.models.FeeLocalModel
import com.example.local.models.PayConfigurationLocalModel

@Database(
    entities = [FeeLocalModel::class, PayConfigurationLocalModel::class, FeeGroupLocalModel::class],
    version = CommonLocal.database_version,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun feeDao(): FeeDao

    companion object {
        private const val DATABASE_NAME = "cross_db.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(@NonNull context: Context): AppDataBase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        DATABASE_NAME,
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }
}
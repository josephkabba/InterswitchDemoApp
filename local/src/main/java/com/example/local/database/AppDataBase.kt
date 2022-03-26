package com.example.local.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.local.CommonLocal
import com.example.local.models.FeeLocalDataModel

@Database(
    entities = [FeeLocalDataModel::class],
    version = CommonLocal.database_version,
    exportSchema = false
)
abstract class AppDataBase: RoomDatabase() {


    abstract fun feeDao(): FeeDao

    companion object {
        private val LOCK = Any()
        private const val DATABASE_NAME = "cross_db.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(@NonNull context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            AppDataBase::class.java,
                            DATABASE_NAME,
                        ).build();
                    }
                }
            }
            return INSTANCE!!
        }
    }
}
package com.example.local.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.local.CommonLocal
import com.example.local.converters.DataConverters
import com.example.local.models.FeeLocalModel

@Database(
    entities = [FeeLocalModel::class],
    version = CommonLocal.database_version,
    exportSchema = false
)
@TypeConverters(DataConverters::class)
abstract class AppDataBase : RoomDatabase() {


    abstract fun feeDao(): FeeDao

    companion object {
        private const val DATABASE_NAME = "cross_db.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(@NonNull context: Context): AppDataBase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        DATABASE_NAME,
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
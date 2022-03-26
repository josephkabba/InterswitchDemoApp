package com.example.local.converters

import androidx.room.TypeConverter
import com.example.local.models.FeeGroupLocalModel
import com.example.local.models.PayConfigurationLocalModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverters {
    private var gson: Gson = Gson()

    @TypeConverter
    fun fromFeeGroupLocalModel(data: List<FeeGroupLocalModel>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun toFeeGroupLocalModel(data: String): List<FeeGroupLocalModel> {
        val listType = object : TypeToken<List<FeeGroupLocalModel>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromGeneric(data: List<Any>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun toGeneric(data: String): List<Any> {
        val listType = object : TypeToken<List<Any>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromPayConfigurationLocalModel(data: List<PayConfigurationLocalModel>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun toPayConfigurationLocalModel(data: String): List<PayConfigurationLocalModel> {
        val listType = object : TypeToken<List<PayConfigurationLocalModel>>() {}.type
        return gson.fromJson(data, listType)
    }
}
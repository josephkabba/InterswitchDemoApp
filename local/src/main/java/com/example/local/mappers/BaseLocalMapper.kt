package com.example.local.mappers

interface BaseLocalMapper<LOCAL, DATA> {

    fun toData(local: LOCAL): DATA

    fun toLocal(data: DATA): LOCAL

}
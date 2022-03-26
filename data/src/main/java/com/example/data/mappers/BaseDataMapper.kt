package com.example.data.mappers

interface BaseDataMapper<T, E> {

    fun toData(e: E): T

    fun toDomain(t: T): E

}
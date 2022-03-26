package com.example.remote.mappers

interface BaseRemoteMapper<R, D> {
    fun toRemote(d: D): R

    fun toData(r: R): D
}
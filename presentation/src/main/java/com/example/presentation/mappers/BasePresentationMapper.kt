package com.example.presentation.mappers

interface BasePresentationMapper<T, E> {

    fun toPresentation(e: E): T

    fun toDomain(t: T): E

}

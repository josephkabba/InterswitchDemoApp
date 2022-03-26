package com.example.presentation

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val errors: Any? = null) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T? = null, errors: Any? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, errors)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    LOADING,
    ERROR,
    SUCCESS
}
package com.example.interswitchdemoapp.network


sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}

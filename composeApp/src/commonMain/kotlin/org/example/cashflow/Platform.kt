package org.example.cashflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
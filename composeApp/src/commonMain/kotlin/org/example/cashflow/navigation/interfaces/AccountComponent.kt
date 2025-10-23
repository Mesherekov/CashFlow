package org.example.cashflow.navigation.interfaces

interface AccountComponent {
    fun getPerson()
    fun changes(changes: Changes)
}

enum class Changes{
    NAME, AVATAR
}
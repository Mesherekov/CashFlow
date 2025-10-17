package org.example.cashflow.navigation

interface RootComponentPattern {
    fun navigateTo(route: String)
    fun getRoute(): String
    var currentRoute: String
}
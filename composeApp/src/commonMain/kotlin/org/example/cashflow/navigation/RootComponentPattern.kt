package org.example.cashflow.navigation

interface RootComponentPattern {
    fun navigateTo(route: RootComponent.Config)
    fun getRoute(): String
    var currentRoute: String
}
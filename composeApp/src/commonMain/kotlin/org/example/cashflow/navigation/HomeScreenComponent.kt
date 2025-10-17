package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext

class HomeScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, HomeComponent {

}
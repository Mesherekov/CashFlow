package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext

class AccountScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, AccountComponent {

}
package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext

class AccountScreenComponent(
    override val num: Int,
    componentContext: ComponentContext
): ComponentContext by componentContext, AccountComponent {

}
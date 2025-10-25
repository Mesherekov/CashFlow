package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext
import org.example.cashflow.navigation.interfaces.AccountComponent
import org.example.cashflow.navigation.interfaces.Changes

class AccountScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, AccountComponent {
    override fun getPerson() {
        TODO("Not yet implemented")
    }

    override fun changes(changes: Changes) {
        when(changes){
            Changes.AVATAR -> {}
            Changes.NAME -> {}
        }
    }

}
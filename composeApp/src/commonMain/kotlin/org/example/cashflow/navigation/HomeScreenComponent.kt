package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext
import org.example.cashflow.navigation.interfaces.HomeComponent

class HomeScreenComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, HomeComponent {
    override fun getWastes() {
        TODO("Not yet implemented")
    }

    override fun updateWaste(index: Int) {
        TODO("Not yet implemented")
    }

    override fun deleteWaste(index: Int) {
        TODO("Not yet implemented")
    }

}
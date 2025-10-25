package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.serialization.Serializable
import org.example.cashflow.navigation.interfaces.RootComponentPattern

class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, RootComponentPattern {
    private val navigation = StackNavigation<Config>()
    val childStack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.HomeScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Config,
        context: ComponentContext
    ): Child {
        return when(config){
            is Config.AccountScreen -> Child.AccountScreen(
                AccountScreenComponent(context)
            )
            Config.HomeScreen -> Child.HomeScreen(
                HomeScreenComponent(context)
            )
        }
    }
   override fun navigateTo(route: Config){
       navigation.replaceCurrent(route)
    }

    override fun getRoute(): String {
        return currentRoute
    }

    override var currentRoute = "home"

    sealed class Child{
        data class HomeScreen(val component: HomeScreenComponent): Child()
        data class AccountScreen(val component: AccountScreenComponent): Child()
    }

    @Serializable
    sealed class Config {
        @Serializable
        data object HomeScreen: Config()

        @Serializable
        data object AccountScreen: Config()
    }
}
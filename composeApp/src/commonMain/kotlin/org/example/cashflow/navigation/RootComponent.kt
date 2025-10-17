package org.example.cashflow.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

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
                AccountScreenComponent(config.num, context)
            )
            Config.HomeScreen -> Child.HomeScreen(
                HomeScreenComponent(context)
            )
        }
    }
   override fun navigateTo(route: String){
       currentRoute = route
        when(route){
            "home" -> {
                navigation.pushNew(Config.HomeScreen)
            }
            "person" -> navigation.pushNew(Config.AccountScreen(1))
        }
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
        data class AccountScreen(val num: Int): Config()
    }
}
package org.example.cashflow.di

import com.arkivanov.decompose.ComponentContext
import org.example.cashflow.navigation.RootComponent
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule = module {
    single { (componentContext: ComponentContext) ->
        RootComponent(componentContext)
    }
}
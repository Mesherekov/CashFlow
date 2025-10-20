package org.example.cashflow.di

import com.arkivanov.decompose.ComponentContext
import org.example.cashflow.navigation.RootComponent
import org.example.cashflow.navigation.RootComponentPattern
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::RootComponent).bind< RootComponentPattern>()
}

expect val platformModule: Module
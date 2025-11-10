@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package org.example.cashflow.di

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.retainedComponent
import org.example.cashflow.database.getWasteDatabase
import org.example.cashflow.navigation.RootComponent
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual interface PlatformComponentContext {
    val androidContext: Context
}

class AndroidComponentContext(
    override val androidContext: Context
) : PlatformComponentContext

actual val platformModule = module {
    single { (componentContext: ComponentContext) ->
        RootComponent(componentContext, get())
    }
    factory<PlatformComponentContext> { (context: Context) ->
        AndroidComponentContext(context)
    }
    singleOf(::getWasteDatabase)
}
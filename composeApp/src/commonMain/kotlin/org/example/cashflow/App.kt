package org.example.cashflow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import cashflow.composeapp.generated.resources.Res
import cashflow.composeapp.generated.resources.addi
import cashflow.composeapp.generated.resources.home
import cashflow.composeapp.generated.resources.home_bar
import cashflow.composeapp.generated.resources.person
import cashflow.composeapp.generated.resources.person_bar
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.example.cashflow.navigation.BottomNavBar
import org.example.cashflow.navigation.BottomNavItem
import org.example.cashflow.navigation.RootComponent
import org.example.cashflow.ui.AccountScreen
import org.example.cashflow.ui.ColorsUI
import org.example.cashflow.ui.HomeScreen
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.core.context.KoinContext

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val childStack by rootComponent.childStack.subscribeAsState()
        Scaffold(
            contentColor = Color.White,
            bottomBar = {
                BottomNavBar(
                    listOf(
                        BottomNavItem(
                            stringResource(Res.string.home_bar),
                            vectorResource(Res.drawable.home),
                            RootComponent.Config.HomeScreen
                        ),
                        BottomNavItem(
                            stringResource(Res.string.person_bar),
                            vectorResource(Res.drawable.person),
                            RootComponent.Config.AccountScreen
                        )
                    ),
                    rootComponent = rootComponent

                )
            },
            floatingActionButton = {
                AnimatedVisibility(
                    visible = childStack.active.configuration == RootComponent.Config.HomeScreen,
                    enter = scaleIn(),
                    exit = scaleOut(),
                ) {
                    FloatingActionButton(
                        onClick = {},
                        shape = CircleShape,
                        containerColor = ColorsUI.light_blue,
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.addi),
                            contentDescription = "add",
                            tint = Color(0xFFFFFFFFF),
                            modifier = Modifier.scale(1.4f)
                        )
                    }
                }
            }
        ) { innerPadding ->
            Children(
                stack = childStack,
                animation = stackAnimation (slide())
            ){
                    child ->
                when(val instance = child.instance){
                    is RootComponent.Child.AccountScreen -> AccountScreen(instance.component)
                    is RootComponent.Child.HomeScreen -> {
                        HomeScreen(instance.component,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding))
                    }
                }
            }

        }
    }
}
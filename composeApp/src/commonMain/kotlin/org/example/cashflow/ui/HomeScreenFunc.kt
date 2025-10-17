package org.example.cashflow.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.cashflow.navigation.HomeScreenComponent
import org.example.cashflow.navigation.RootComponent

@Composable
fun HomeScreen(component: HomeScreenComponent){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text("Main")
    }
}
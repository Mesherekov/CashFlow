package org.example.cashflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.retainedComponent
import org.example.cashflow.navigation.RootComponent
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val root: RootComponent by inject{ parametersOf(retainedComponent {
            it
        }) }
        setContent {
            App(root)
        }
    }
}


package org.example.cashflow.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.router.stack.active
import org.example.cashflow.ui.ColorsUI

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: RootComponent.Config,
    val badgeCount: Int = 0
)
@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    modifier: Modifier = Modifier,
    rootComponent: RootComponent
){
    NavigationBar(
        modifier = modifier,
        containerColor = ColorsUI.light_blue,

        tonalElevation = 5.dp
    ) {
        var isSelected by remember { mutableStateOf(rootComponent.childStack.active.configuration) }
        items.forEach { item ->
            val selected = isSelected == item.route
            NavigationBarItem(
                selected = selected,
                onClick = { rootComponent.navigateTo(item.route)
                          isSelected = rootComponent.childStack.active.configuration
                          },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = ColorsUI.cian,
                    selectedIconColor = Color(0xFFFFFFFFF),
                    selectedTextColor = Color(0xFFFFFFFFF),
                    unselectedIconColor = Color(0xFFFFFFFFF),
                    unselectedTextColor = Color(0xFFFFFFFFF)

                ),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.scale(1.3f)
                            )

                        Text(
                            text = item.label,
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp
                        )
                    }
                }
            )
        }
    }
}

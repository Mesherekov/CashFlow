package org.example.cashflow.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route:String,
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
        containerColor = Color(0xFFF93737),

        tonalElevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = rootComponent.getRoute() == item.route
            NavigationBarItem(
                selected = selected,
                onClick = { rootComponent.navigateTo(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFA4A4A4),
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

package org.example.cashflow.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.cashflow.navigation.HomeScreenComponent
import org.example.cashflow.ui.donut_chart.DonutChart


@Composable
fun HomeScreen(component: HomeScreenComponent,
               modifier: Modifier = Modifier.fillMaxWidth()
){
    Box(modifier = modifier){
        Column {
            DonutChart(
                data = mapOf(
                    Pair("Transport", 20),
                    Pair("Home", 70),
                    Pair("Food", 30),
                    Pair("Shopping", 200),
                    Pair("Games", 70),
                    Pair("Dance", 30),
                )
            )
            repeat(7){
                //WasteItem()
            }
        }
    }
}

@Composable
fun WasteItem(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = ColorsUI.light_blue,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Column(modifier = Modifier.padding(2.dp)) {
                Text("Покупки",
                    Modifier.padding(bottom = 2.dp))
                Text("19.06.2025",
                    Modifier.padding(bottom = 3.dp))
            }
            Box(Modifier.weight(1f),
                contentAlignment = Alignment.CenterEnd){
                Row {
                    Text("1340$",
                        fontSize = 20.sp)
                    IconButton(onClick = {},
                        modifier = Modifier.size(24.dp)){
                        Icon(imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "more_info")
                    }
                }
            }
        }
    }
}

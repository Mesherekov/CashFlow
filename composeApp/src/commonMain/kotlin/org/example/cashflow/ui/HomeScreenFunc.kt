package org.example.cashflow.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.cashflow.db.WasteItemDB
import org.example.cashflow.navigation.HomeScreenComponent
import org.example.cashflow.ui.donut_chart.DonutChart
import org.example.cashflow.ui.waste.WasteCategories
import org.example.cashflow.ui.waste.WasteItem
import org.jetbrains.compose.resources.stringResource



@Composable
fun HomeScreen(component: HomeScreenComponent,
               modifier: Modifier = Modifier.fillMaxWidth()
){
    val wasteCategories = WasteCategories.entries.toTypedArray()
    Box(modifier = modifier){
        Column {
            DonutChart(
                data = mapOf(
                    Pair(stringResource(wasteCategories[0].title), 20),
                    Pair(stringResource(wasteCategories[1].title), 70),
                    Pair(stringResource(wasteCategories[2].title), 30),
                    Pair(stringResource(wasteCategories[3].title), 90),
                    Pair(stringResource(wasteCategories[4].title), 70),
                    Pair(stringResource(wasteCategories[5].title), 30),
                )
            )
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
                ) {
                for (i in 0..5) {
                    WasteItem(
                        WasteItemDB(
                            wasteCategories[i],
                            (i * 1.4 + 1 * 13*1.5).toFloat()
                        )
                    )
                }
            }
        }
    }
}


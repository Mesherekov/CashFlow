package org.example.cashflow.ui.waste

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.example.cashflow.db.WasteCard
import org.example.cashflow.db.WasteItemDB

@Composable
fun WasteCard(wasteCard: WasteCard){
    if (wasteCard.listWaste.size>1){
        Card(elevation = CardDefaults.elevatedCardElevation(3.dp)) {
            Column {
                wasteCard.listWaste.forEachIndexed { index, value ->
                    WasteItem(
                        WasteItemDB(
                            value.wasteCategory,
                            value.cost,
                            value.currency
                        )
                    )
                }
            }
        }
    }else{
        Card(elevation = CardDefaults.elevatedCardElevation(3.dp)) {
            val wasteFirst = wasteCard.listWaste.first()
            WasteItem(
                WasteItemDB(
                    wasteFirst.wasteCategory,
                    wasteFirst.cost,
                    wasteFirst.currency
                )
            )
        }
    }
}
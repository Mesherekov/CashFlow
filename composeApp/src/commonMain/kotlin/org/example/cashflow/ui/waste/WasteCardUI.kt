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
    if (wasteCard.cost.size>1){
        Card(elevation = CardDefaults.elevatedCardElevation(3.dp)) {
            Column {
                wasteCard.cost.forEachIndexed { index, value ->
                    WasteItem(
                        WasteItemDB(
                            wasteCard.listWasteCategories[index],
                            value,
                            wasteCard.currency[index]
                        )
                    )
                }
            }
        }
    }else{
        Card(elevation = CardDefaults.elevatedCardElevation(3.dp)) {
            WasteItem(
                WasteItemDB(
                    wasteCard.listWasteCategories.first(),
                    wasteCard.cost.first(),
                    wasteCard.currency.first()
                )
            )
        }
    }
}
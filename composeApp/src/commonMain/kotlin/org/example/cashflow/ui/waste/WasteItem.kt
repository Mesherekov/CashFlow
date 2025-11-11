package org.example.cashflow.ui.waste

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.cashflow.db.WasteItemDB
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.pow
import kotlin.math.round

@Preview(showBackground = true)
@Composable
fun WasteItem(wasteItem: WasteItemDB){
    Column{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Icon(
            imageVector = wasteItem.wasteCategory.icon,
            contentDescription = wasteItem.wasteCategory
                .name
                .lowercase(),
            Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = stringResource(wasteItem.wasteCategory.title),
            fontSize = 19.sp
        )
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(wasteItem.currency.icon,
                    contentDescription = "currency")
                Text(
                    text = "${
                        wasteItem
                            .cost
                            .toDouble()
                            .roundTo(2)
                    }",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(3.dp)
                )
            }
        }
    }
        HorizontalDivider(color = Color.LightGray)
    }
}
fun Double.roundTo(dec: Int): Double {
    return round(this * 10.0.pow(dec)) / 10.0.pow(dec)
}

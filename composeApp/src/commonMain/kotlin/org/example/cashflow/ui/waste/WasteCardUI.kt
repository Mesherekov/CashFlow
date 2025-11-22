package org.example.cashflow.ui.waste

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.cashflow.db.WasteCard
import org.example.cashflow.db.WasteItemDB

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WasteCard(wasteCard: WasteCard){
    Card(
        elevation = CardDefaults.elevatedCardElevation(3.dp),
        modifier = Modifier.padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        val rotation = remember { Animatable(initialValue = 1f) }
        var isExpanded by remember { mutableStateOf(false) }
        Column{
            Row(Modifier.padding(5.dp)) {
                Text(wasteCard.date)
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                    ){
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = wasteCard.listWaste.sumOf { it.cost.toDouble() }.toString(),
                            fontSize = 18.sp
                        )
                        if (wasteCard.listWaste.size > 1) {

                            LaunchedEffect(isExpanded) {
                                rotation.animateTo(
                                    targetValue = if (isExpanded) 180f else 1f
                                )
                            }
                            IconButton(onClick = {
                                isExpanded = !isExpanded
                            }){
                                Icon(Icons.Default.ArrowDropDown,
                                    contentDescription = "arrow_down",
                                    modifier = Modifier.graphicsLayer{
                                        rotationX = rotation.value
                                    }
                                )
                            }

                        }
                    }
                }
            }
            if (wasteCard.listWaste.size > 1) {
                AnimatedContent(
                    targetState = isExpanded,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(durationMillis = 150))
                            .togetherWith(fadeOut(animationSpec = tween(durationMillis = 150))) using
                                SizeTransform { initialSize, targetSize ->
                                    if (targetState) {
                                        keyframes {
                                            IntSize(initialSize.width, initialSize.height) at 150
                                            durationMillis = 300
                                        }
                                    } else {
                                        keyframes {
                                            IntSize(targetSize.width, targetSize.height) at 150
                                            durationMillis = 300
                                        }
                                    }
                                }
                    }
                ) { targetExpanded ->
                    if (targetExpanded) {
                        Column {
                            wasteCard.listWaste.forEach { value ->
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
                }

            } else{
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

}
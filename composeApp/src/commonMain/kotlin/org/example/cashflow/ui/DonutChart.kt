package org.example.cashflow.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DonutChart(
    data: Map<String, Int>,
    radius: Dp = 90.dp,
    chartBarWidth: Dp = 20.dp,
    animDuration: Int = 1000
){
    val totalSum = data.values.sum()
    val floatValue = mutableListOf<Float>()
    data.values.forEachIndexed { index, item ->
        floatValue.add(index, 360*item.toFloat() / totalSum.toFloat())
    }

    val colors = mutableListOf(
        ColorsUI.light_cian,
        ColorsUI.light_green,
        ColorsUI.dark_cian,
        ColorsUI.color70,
        ColorsUI.color30,
        ColorsUI.color50,
        ColorsUI.color90
    )
    var animationPlayed by remember { mutableStateOf(false) }

    var lastValue = 0f
    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radius.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Row {
        AnimatedVisibility(
            visible = animationPlayed,
            enter = scaleIn(animationSpec = tween(durationMillis = 300,
                easing = LinearEasing)),
            exit = scaleOut(animationSpec = tween(durationMillis = 300,
                delayMillis = 670))
        ) {
            DetailsDonutChart(
                data = data,
                colors = colors,
                modifier = Modifier
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 3.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(animateSize.dp)
                    .clickable {
                        animationPlayed = !animationPlayed
                    },
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier
                        .size(radius * 2f)
                        .rotate(animateRotation),
                ) {
                    floatValue.forEachIndexed { index, value ->
                        drawArc(
                            color = colors[index],
                            lastValue,
                            value,
                            useCenter = false,
                            style = Stroke(
                                chartBarWidth.toPx(),
                                cap = StrokeCap.Butt
                            )
                        )
                        lastValue += value
                    }
                }
            }

        }
    }

}

@Composable
fun DetailsDonutChart(
    data: Map<String, Int>,
    colors: List<Color>,
    modifier: Modifier
){
    Column(modifier = modifier
        .padding(top = 50.dp)) {
        data.values.forEachIndexed { index, i ->
            DetailsDonutItem(
                data = Pair(data.keys.elementAt(index), i),
                color = colors[index]
            )

        }
    }
}

@Composable
fun DetailsDonutItem(
    data: Pair<String, Int>,
    height: Dp = 45.dp,
    color: Color
){
    Surface(
        modifier = Modifier
        .padding(vertical = 10.dp,
            horizontal = 30.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                .background(color = color,
                    shape = RoundedCornerShape(10.dp)
                )
                    .size(height)
            )
            Column {
                Text(
                    modifier = Modifier.padding(start = 15.dp),
                    text = data.first,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }

        }
    }
}
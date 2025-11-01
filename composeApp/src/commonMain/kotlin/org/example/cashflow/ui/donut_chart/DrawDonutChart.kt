package org.example.cashflow.ui.donut_chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun DrawDonutChart(
    radius: Dp,
    animateRotation: Float,
    floatValue: MutableList<Float>,
    colors: MutableList<Color>,
    chartBarWidth: Dp,
    animationPlayed: Boolean,
    data: Map<String, Int>
) {
    var lastValue = 0f
    Canvas(
        modifier = Modifier
            .padding(30.dp)
            .size(radius * 2f)
            .rotate(animateRotation),
    ) {
        val chartRadius = size.minDimension// - 35
        val strokeWidth = 40.dp.toPx()
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

        floatValue.forEachIndexed { index, value ->
            val middleAngle = lastValue + value / 2
            val angleInRad = (middleAngle * PI / 180).toFloat()
            val textRadius = chartRadius + strokeWidth * 0.7f
            val textX = center.x + textRadius * cos(angleInRad) * 0.6f
            val textY = center.y + textRadius * sin(angleInRad) * 0.7f

            rotate(
                degrees = 90f,
                pivot = Offset(textX, textY)
            ) {
                if (animationPlayed) {
                    val text = data.keys.elementAt(index)

                    drawTextItem(
                        text,
                        textX,
                        textY,
                        Color.Black,
                        16.sp
                    )
                }
            }
            lastValue += value
        }
    }
}

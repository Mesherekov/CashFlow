package org.example.cashflow.ui.donut_chart

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.TextUnit

actual fun DrawScope.drawTextItem(
    text: String,
    x: Float,
    y: Float,
    color: Color,
    textSize: TextUnit
) {

    drawContext.canvas.nativeCanvas.apply {
        drawText(

            text,
            x,
            y,
            android.graphics.Paint().apply {
                this.color = color.toArgb()
                textAlign = android.graphics.Paint.Align.CENTER
                this.textSize = textSize.toPx()
            }
        )

    }
}
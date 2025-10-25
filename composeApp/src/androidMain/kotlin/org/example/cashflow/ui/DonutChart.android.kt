package org.example.cashflow.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.TextUnit
import kotlin.apply

actual fun DrawScope.drawTextItem(
    text: String,
    x: Float,
    y: Float,
    color: Color,
    textSize: TextUnit
) {
    drawContext.canvas.nativeCanvas.apply {
//        drawText(text, x, y, paint = Paint().apply {
//                this.color = color
//            } as android.graphics.Paint)
    }
}
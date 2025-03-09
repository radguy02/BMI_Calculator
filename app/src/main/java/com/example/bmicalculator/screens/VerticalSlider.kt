package com.example.bmicalculator.screens

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter

private const val MAX_VALUE = 200
private const val MIN_VALUE = 120

class ComposeVerticalSliderState {
    var isEnabled = mutableStateOf(true)
        internal set
    var adjustTop = mutableStateOf(0f)
        internal set
    var progressValue = mutableStateOf(0)
        internal set

    private fun updateAdjustTopValue(value: Float) {
        this.adjustTop.value = value
    }

    private fun updateProgressValue(value: Int) {
        this.progressValue.value = value
    }

    internal fun updateOnTouch(
        motionEvent: MotionEvent,
        canvasHeight: Int
    ) {
        if (!isEnabled.value) return

        val y = motionEvent.y.roundToInt()

        updateAdjustTopValue(y.toFloat())

        val progress = calculateProgress(y.toFloat(), canvasHeight).coerceIn(MIN_VALUE, MAX_VALUE)

        updateProgressValue(progress)
    }

    private fun calculateProgress(adjustTop: Float, canvasHeight: Int): Int {
        return MAX_VALUE - (adjustTop / canvasHeight).times(100).roundToInt()
    }

    fun calculateAdjustTopFromProgressValue(progressValue: Int, canvasHeight: Int): Float {
        return (MAX_VALUE - progressValue).times(canvasHeight).div(100).toFloat()
    }
}

@Composable
fun rememberComposeVerticalSlider(): ComposeVerticalSliderState {
    return remember { ComposeVerticalSliderState() }
}

@ExperimentalComposeUiApi
@Composable
fun VerticalSlider(
    state: ComposeVerticalSliderState,
    progressValue: Int? = null,
    enabled: Boolean = true,
    modifier: Modifier = Modifier, 
    radius: CornerRadius = CornerRadius(80f, 80f),
    trackColor: Color = Color.LightGray,
    progressTrackColor: Color = Color.Green,
    onProgressChanged: (Int) -> Unit,
    onStopTrackingTouch: (Int) -> Unit
) {
    var canvasHeight by remember { mutableStateOf(0) }
    val enabledState by rememberSaveable { state.isEnabled }
    var progressValueData by rememberSaveable { mutableStateOf(state.progressValue.value) }

    // Ensure progressValue is updated when passed externally
    LaunchedEffect(progressValue) {
        if (progressValue != null) {
            progressValueData = progressValue
            onProgressChanged(progressValue)
            onStopTrackingTouch(progressValue)
        }
    }

    val trackPaint = Paint().apply {
        color = trackColor
        isAntiAlias = true
        strokeWidth = 10f
    }

    val progressPaint = Paint().apply {
        color = if (enabledState) progressTrackColor else Color.Gray
        isAntiAlias = true
        strokeWidth = 10f
    }

    Canvas(
        modifier = modifier
            .pointerInteropFilter { motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                        if (enabledState) {
                            state.updateOnTouch(motionEvent, canvasHeight)
                            progressValueData = state.progressValue.value
                            onProgressChanged(progressValueData)
                        }
                        enabledState
                    }
                    MotionEvent.ACTION_UP -> {
                        if (enabledState) {
                            state.updateOnTouch(motionEvent, canvasHeight)
                            progressValueData = state.progressValue.value
                            onStopTrackingTouch(progressValueData)
                        }
                        enabledState
                    }
                    else -> false
                }
            }
    ) {
        canvasHeight = size.height.roundToInt()
        val rect = Rect(0f, 0f, size.width, size.height)
        val progressTop = state.calculateAdjustTopFromProgressValue(progressValueData, canvasHeight)

        // Draw track background
        drawRoundRect(
            color = trackColor,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height),
            cornerRadius = CornerRadius(radius.x, radius.y)
        )

        // Draw progress
        drawRoundRect(
            color = progressTrackColor,
            topLeft = Offset(0f, progressTop),
            size = Size(size.width, size.height - progressTop),
            cornerRadius = CornerRadius(radius.x, radius.y)
        )
    }
}












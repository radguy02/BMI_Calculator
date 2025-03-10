package com.example.bmicalculator.screens

import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var calculatedValue = mutableFloatStateOf(0.0f)

    fun calculateValue(weight: Int, height: Int) {
        calculatedValue.floatValue = weight / ((height / 100f) * (height / 100f))

    }
}

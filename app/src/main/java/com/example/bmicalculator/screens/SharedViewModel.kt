package com.yourapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf

class SharedViewModel : ViewModel() {
    var calculatedValue = mutableStateOf(0)
        private set

    fun calculateValue(height: Int, weight: Int) {
        calculatedValue.value = weight/(height*height)
    }
}

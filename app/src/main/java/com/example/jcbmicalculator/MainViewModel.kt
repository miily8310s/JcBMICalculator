package com.example.jcbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel: ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableFloatStateOf(0f)

    fun calculateBMI() {
        // div -> 100で割る, nullだったら0fに
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNumber = weight.toFloatOrNull() ?: 0f

        bmi =  if (heightNumber > 0f && weightNumber > 0f) {
            ( weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}
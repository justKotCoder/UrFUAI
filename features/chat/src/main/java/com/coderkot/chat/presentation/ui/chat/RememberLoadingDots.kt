package com.coderkot.chat.presentation.ui.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
import androidx.compose.runtime.State

@Composable
fun rememberLoadingDots(): State<Int> {
    val dots = remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            dots.intValue = (dots.intValue + 1) % 4
        }
    }
    return dots
}

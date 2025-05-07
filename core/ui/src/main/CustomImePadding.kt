package com.coderkot.utils.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.platform.LocalDensity

@Composable
fun Modifier.customImePadding() = this.then(
    Modifier.padding(bottom = with(LocalDensity.current) {
        (WindowInsets.ime.getBottom(this) - WindowInsets.navigationBars.getBottom(this)).toDp()
    })
)
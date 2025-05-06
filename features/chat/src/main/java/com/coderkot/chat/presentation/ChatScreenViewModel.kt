package com.coderkot.chat.presentation

import androidx.lifecycle.ViewModel
import com.coderkot.chat.domain.usecases.GetResponseUseCase

class ChatScreenViewModel(
    private val getResponseUseCase: GetResponseUseCase
): ViewModel() {

}
package com.coderkot.chat.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderkot.chat.domain.model.ChatMessage
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import com.coderkot.utils.ApiState
import kotlinx.coroutines.launch

class ChatScreenViewModel(
    private val getResponseUseCase: GetResponseUseCase
) : ViewModel() {
    private val _messages = mutableStateListOf<ChatMessage>().apply {
        add(ChatMessage("assistant", "Привет! Я твой друг!"))
    }
    val messages: List<ChatMessage> = _messages


    fun sendUserMessage(prompt: String) {

        val initialMessageCount = _messages.size
        _messages.add(ChatMessage("user", prompt))

        _messages.add(ChatMessage("assistant", "Бужу нашего тьютора", isLoading = true))

        viewModelScope.launch {
            when (val result = getResponseUseCase(prompt)) {
                is ApiState.Success -> {
                    _messages.removeAt(initialMessageCount + 1)
                    _messages.add(
                        ChatMessage(
                            "assistant",
                            result.data?.choices[0]!!.message.content.toString()
                        )
                    )
                }

                is ApiState.Error -> {
                    Log.d("ERROR!", result.message.toString())
                }

                is ApiState.Loading -> {

                }
            }
        }
    }

}
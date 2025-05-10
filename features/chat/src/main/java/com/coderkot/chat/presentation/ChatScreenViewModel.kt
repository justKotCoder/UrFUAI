package com.coderkot.chat.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderkot.chat.domain.model.ChatMessage
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import com.coderkot.chat.presentation.mapper.toUI
import com.coderkot.utils.ApiState
import kotlinx.coroutines.launch

class ChatScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getResponseUseCase: GetResponseUseCase
) : ViewModel() {
    private val _messages = mutableStateListOf<ChatMessageUi>().apply {
        val saved = savedStateHandle.get<List<ChatMessageUi>>("messages")
        if (saved != null) {
            addAll(saved)
        } else {
            add(ChatMessage(role = "assistant", content = "Привет! Я твой друг!").toUI())
        }
    }
    val messages: List<ChatMessageUi> = _messages


    fun sendUserMessage(prompt: String) {

        val initialMessageCount = _messages.size
        _messages.add(ChatMessage("user", prompt).toUI())

        _messages.add(ChatMessage("assistant", "Бужу нашего тьютора", isLoading = true).toUI())

        viewModelScope.launch {
            when (val result = getResponseUseCase(prompt)) {
                is ApiState.Success -> {
                    _messages.removeAt(initialMessageCount + 1)
                    _messages.add(
                        ChatMessage(
                            "assistant",
                            result.data?.choices[0]!!.message.content.toString()
                        ).toUI()
                    )
                    saveMessages()
                }

                is ApiState.Error -> {
                    Log.d("ERROR!", result.message.toString())
                }

                is ApiState.Loading -> {

                }
            }
        }
    }

    private fun saveMessages() {
        savedStateHandle["messages"] = _messages.map { it.copy() }
    }

}
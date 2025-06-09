package com.coderkot.chat.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderkot.chat.domain.model.ChatMessage
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import com.coderkot.chat.domain.usecases.FindAnswerInJsonUseCase
import com.coderkot.utils.ApiState
import kotlinx.coroutines.launch

class ChatScreenViewModel(
    private val getResponseUseCase: GetResponseUseCase,
    private val findAnswerInJsonUseCase: FindAnswerInJsonUseCase
) : ViewModel() {

    private val _messages = mutableStateListOf<ChatMessage>().apply {
        add(ChatMessage("assistant", "Привет! Я твой друг!"))
    }
    val messages: List<ChatMessage> = _messages

    fun sendUserMessage(prompt: String) {
        val initialMessageCount = _messages.size
        _messages.add(ChatMessage("user", prompt))
        _messages.add(ChatMessage("assistant", "Бужу нашего Тьютора", isLoading = true))

        viewModelScope.launch {
            try {
                val localAnswer = findAnswerInJsonUseCase(prompt)
                _messages.removeAt(initialMessageCount + 1)

                if (localAnswer != null) {
                    _messages.add(ChatMessage("assistant", localAnswer.text))
                } else {
                    when (val result = getResponseUseCase(prompt)) {
                        is ApiState.Success -> {
                            val reply = result.data?.choices?.firstOrNull()?.message?.content
                            _messages.add(ChatMessage("assistant", reply ?: "Ответ от ИИ пуст..."))
                        }
                        is ApiState.Error -> {
                            Log.e("ChatVM", "Ошибка API: ${result.message}")
                            _messages.add(ChatMessage("assistant", "перейдите в раздел Тьютор"))
                        }
                        is ApiState.Loading -> {
                            // Игнорируется, так как мы сами контролируем индикатор загрузки
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("ChatVM", "Ошибка при обработке сообщения", e)
                _messages.removeAt(initialMessageCount + 1)
                _messages.add(ChatMessage("assistant", "Что-то пошло не так..."))
            }
        }
    }
}

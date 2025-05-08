package com.coderkot.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: HomeRepository
) : ViewModel() {
    sealed class HomeState {
        object Loading : HomeState()
        data class Success(val items: List<HomeItem>) : HomeState()
        data class Error(val message: String) : HomeState()
    }

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.value = try {
                HomeState.Success(repository.getHomeItems())
            } catch (e: Exception) {
                HomeState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
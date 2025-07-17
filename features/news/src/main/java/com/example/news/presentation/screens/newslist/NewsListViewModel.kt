package com.example.news.presentation.screens.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.model.News
import com.example.news.domain.usecases.GetNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val getNews: GetNewsUseCase
) : ViewModel() {
    private val _news = MutableStateFlow<List<News>>(emptyList())
    val news = _news.asStateFlow()

    private val _selectedNews = MutableStateFlow<News?>(null)
    val selectedNews = _selectedNews.asStateFlow()

    init {
        loadNews()
    }

    fun loadNews() {
        viewModelScope.launch {
            _news.value = getNews()
        }
    }

    fun selectNews(news: News) {
        _selectedNews.value = news
    }

    fun dismissDetails() {
        _selectedNews.value = null
    }
}
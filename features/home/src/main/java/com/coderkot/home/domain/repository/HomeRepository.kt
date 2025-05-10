package com.coderkot.home.domain.repository

import com.coderkot.home.domain.model.HomeItem

interface HomeRepository {
    suspend fun getHomeItems(): List<HomeItem>
}
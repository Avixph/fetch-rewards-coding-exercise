package com.example.fetchrewardscodingexercise.data

import com.example.fetchrewardscodingexercise.network.FetchApiService
import com.example.fetchrewardscodingexercise.model.FetchListItem

interface FetchListsRepository {
    suspend fun getFetchLists(): List<FetchListItem>
}

class FetchListsNetworkRepository(
    private val fetchApiService: FetchApiService
) : FetchListsRepository {
    override suspend fun getFetchLists(): List<FetchListItem> {
        return fetchApiService.getLists()
            .filterNot { it.name.isNullOrBlank() }
            .filterNot { it.name.isNullOrEmpty() }
    }
}
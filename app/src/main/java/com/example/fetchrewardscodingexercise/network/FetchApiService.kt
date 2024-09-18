package com.example.fetchrewardscodingexercise.network

import com.example.fetchrewardscodingexercise.model.FetchListItem
import retrofit2.http.GET

interface FetchApiService {
    @GET("hiring.json")
    suspend fun getLists(): List<FetchListItem>
}

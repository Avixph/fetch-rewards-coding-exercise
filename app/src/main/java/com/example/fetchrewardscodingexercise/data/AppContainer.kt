package com.example.fetchrewardscodingexercise.data

import com.example.fetchrewardscodingexercise.network.FetchApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val fetchListsRepository: FetchListsRepository
}

class DefaultAppContainer : AppContainer {
    private val listUrl = "https://fetch-hiring.s3.amazonaws.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(listUrl)
        .build()

    private val retrofitService: FetchApiService by lazy {
        retrofit.create(FetchApiService::class.java)
    }

    override val fetchListsRepository: FetchListsRepository by lazy {
        FetchListsNetworkRepository(retrofitService)
    }

}
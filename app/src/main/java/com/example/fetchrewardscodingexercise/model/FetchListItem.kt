package com.example.fetchrewardscodingexercise.model

import kotlinx.serialization.Serializable

@Serializable
data class FetchListItem(
    val id: Int,
    val listId: Int,
    val name: String?
)

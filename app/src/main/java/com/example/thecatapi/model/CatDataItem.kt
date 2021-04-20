package com.example.thecatapi.model

data class CatDataItem(
    val breeds: List<Any>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)
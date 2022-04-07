package com.example.evntr.API

data class ApiEventFull(
    val _id: String,
    val age: String,
    val category: String,
    val date: String,
    val host: ReferenceObject,
    val image: ImageAsset,
    val name: String,
    val price: String,
    val text: String,
    val venue: String
)
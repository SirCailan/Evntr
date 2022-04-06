package com.example.evntr.API

data class ApiEvent(
    val _id: String,
    val age: String?,
    val cover: ImageAsset?, //URL
    val date: String?,
    val name: String?,
    val price: String?,
    val venue: String?
)

/* val _type: String?,
    val _updatedAt: String?,
    val header: String?,
    val image: Asset?, //URL
    val text: String?,*/
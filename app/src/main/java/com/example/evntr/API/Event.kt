package com.example.evntr.API

import com.beust.klaxon.Json

data class Event(
    @Json(name = "_id") val id: String,
    @Json (serializeNull = false, name = "age") val ageLimit: String?,
    @Json (serializeNull = false) val category: String?,
    @Json (serializeNull = false) val cover: ImageAsset?, //URL
    @Json (serializeNull = false) val date: String?,
    @Json (serializeNull = false) val host: ReferenceObject?,
    @Json (serializeNull = false) val image: ImageAsset?,
    @Json (serializeNull = false) val name: String?,
    @Json (serializeNull = false) val price: String?,
    @Json (serializeNull = false) val text: String?,
    @Json (serializeNull = false) val venue: String?
)
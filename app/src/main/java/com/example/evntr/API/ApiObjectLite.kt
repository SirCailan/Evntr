package com.example.evntr.API

data class ApiObjectLite(
    val ms: Int?,
    val query: String?,
    val result: List<ApiEventLite>?
)
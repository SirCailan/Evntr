package com.example.evntr.API

import com.example.evntr.API.ApiEvent

data class ApiObject(
    val ms: Int?,
    val query: String?,
    val result: List<ApiEvent>?
)
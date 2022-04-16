package com.example.evntr.API

data class ApiObjectEventList(
    val ms: Int?,
    val query: String?,
    val result: MutableList<Event>?
)
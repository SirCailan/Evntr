package com.example.evntr.EventsScreen

import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.beust.klaxon.Klaxon
import com.example.evntr.API.Event
import com.example.evntr.API.ApiObjectEventList

class EventsViewModel : ViewModel() {

    private var eventsList: List<Event> = listOf()

    fun fetchAllEvents(queue: RequestQueue, sortBy: Int, callback: (Boolean) -> Unit) {
        val sortString = getSortString(sortBy)

        val url =
            "https://a9von6e3.api.sanity.io/v2021-10-21/data/query/production?query=*%5B_type%20%3D%3D%20%27event%27%5D%20%7C%20order($sortString)%20%7B%0A%20%20_id%2C%20%0A%20%20name%2C%20%0A%20%20cover%20%7B%0A%20%20%20%20asset-%3E%20%7B%0A%20%20%20%20%20%20url%0A%20%20%20%20%7D%0A%20%20%7D%2C%0A%20%20date%2C%0A%20%20venue%2C%0A%20%20price%2C%0A%20%20age%0A%7D"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val it = Klaxon().parse<ApiObjectEventList>(response)

                if (it?.result != null) {
                    eventsList = it.result

                    callback(true)
                }

            },
            { error ->
                callback(false)
            }
        )

        queue.add(stringRequest)
    }

    fun retrieveEventsList(): List<Event> {
        return eventsList
    }

    private fun getSortString(sortBy: Int): String {

        return when (sortBy) {
            1 -> {
                "date%20desc"
            }
            2 -> {
                "alph%20asc"
            }
            3 -> {
                "alph%20desc" //Does not work???
            }
            else -> {
                "date%20asc" // Technically also when sortBy is 0
            }
        }

    }
}
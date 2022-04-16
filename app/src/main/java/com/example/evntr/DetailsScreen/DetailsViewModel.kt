package com.example.evntr.DetailsScreen

import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.beust.klaxon.Klaxon
import com.example.evntr.API.EventDetails
import com.example.evntr.API.ApiObjectEvent

class DetailsViewModel : ViewModel() {

    fun fetchEventDetails(queue: RequestQueue, eventId: String, callback: (EventDetails?) -> Unit) {
        val url = "https://a9von6e3.api.sanity.io/v2021-10-21/data/query/production?query=*%5B_id%20%3D%3D%20%24__eventID__%5D%5B0%5D%20%7B%0A%20%20_id%2C%0A%20%20name%2C%0A%20%20image%20%7B%0A%20%20%20%20asset-%3E%20%7B%0A%20%20%20%20%20%20url%0A%20%20%20%20%7D%0A%20%20%7D%2C%0A%20%20date%2C%0A%20%20venue%2C%0A%20%20price%2C%0A%20%20host-%3E%20%7B%0A%20%20%20%20name%0A%20%20%7D%2C%0A%20%20category%2C%0A%20%20age%2C%0A%20%20text%0A%7D&%24__eventID__=\"$eventId\""

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val eventObject = Klaxon().parse<ApiObjectEvent?>(response)
                if (eventObject != null) {
                    callback(eventObject.result)
                }
            },
            { error ->
                callback(null)
            }
        )

        queue.add(stringRequest)
    }
}
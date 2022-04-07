package com.example.evntr.DetailsScreen

import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.beust.klaxon.Klaxon
import com.example.evntr.API.ApiEventFull
import com.example.evntr.API.ApiObjectFull

class DetailsViewModel : ViewModel() {

    fun fetchEventDetails(queue: RequestQueue,eventId: String, callback: (ApiEventFull?) -> Unit) {
        val url = "" //TODO add url with $eventId

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val eventObject = Klaxon().parse<ApiObjectFull?>(response)
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
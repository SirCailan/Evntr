package com.example.evntr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evntr.database.Event

class EventsAdapter(
    private val dataset: List<Event>
) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

        val cellView = LayoutInflater.from(parent.context).inflate(R.layout.event_card, parent, false)

        val params: ViewGroup.LayoutParams = cellView.layoutParams
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        cellView.layoutParams = params

        return EventViewHolder(cellView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = dataset[position]

       //TODO: Bind all info to  holder.header.text = event.header
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
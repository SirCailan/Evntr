package com.example.evntr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.evntr.database.DatabaseEvent

class EventsAdapter(
    private val dataset: List<DatabaseEvent>
) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var header: TextView = view.findViewById(R.id.event_card_header)
        var timeDate: TextView = view.findViewById(R.id.event_card_time)
        var location: TextView = view.findViewById(R.id.event_card_location)
        var price: TextView = view.findViewById(R.id.event_card_price)
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

        holder.header.text = event.header
        holder.timeDate.text = event.timeDate
        holder.location.text = event.venue
        holder.price.text = event.price
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
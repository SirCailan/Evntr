package com.example.evntr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.evntr.API.ApiEventLite
import com.example.evntr.EventsScreen.EventsFragmentDirections
import com.squareup.picasso.Picasso

class EventsAdapter(
    private var dataset: MutableList<ApiEventLite>
) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var header: TextView = view.findViewById(R.id.event_card_header)
        var timeDate: TextView = view.findViewById(R.id.event_card_time)
        var location: TextView = view.findViewById(R.id.event_card_location)
        var price: TextView = view.findViewById(R.id.event_card_price)
        var image: ImageView = view.findViewById(R.id.event_card_cover)

        init {
            view.setOnClickListener {
                val eventId = dataset[bindingAdapterPosition]._id

                it.findNavController().navigate(EventsFragmentDirections.actionEventsFragmentToDetailsFragment(eventId))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {

        val cellView =
            LayoutInflater.from(parent.context).inflate(R.layout.event_card, parent, false)

        val params: ViewGroup.LayoutParams = cellView.layoutParams
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        cellView.layoutParams = params

        return EventViewHolder(cellView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = dataset[position]

        holder.header.text = event.name
        holder.timeDate.text = event.date
        holder.location.text = event.venue
        holder.price.text = "Kr. ${event.price},-"
        Picasso.with(holder.image.context).load(event.cover?.asset?.url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun swapDataset(newDataset: MutableList<ApiEventLite>) {
        dataset = newDataset
        notifyDataSetChanged()
    }

}
package com.example.evntr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.evntr.API.Event
import com.example.evntr.EventsScreen.EventsFragmentDirections
import com.example.evntr.profilescreen.ProfileFragmentDirections
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class EventsAdapter(
    private var dataset: List<Event>
) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>(), Filterable {

    private var shownDataset: List<Event> = dataset

    inner class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var header: TextView = view.findViewById(R.id.event_card_header)
        var timeDate: TextView = view.findViewById(R.id.event_card_time)
        var location: TextView = view.findViewById(R.id.event_card_location)
        var price: TextView = view.findViewById(R.id.event_card_price)
        var image: ImageView = view.findViewById(R.id.event_card_cover)

        init {
            view.setOnClickListener {
                val eventId = shownDataset[bindingAdapterPosition].id
                val fragmentId = it.findNavController().currentDestination?.id

                when (fragmentId) {
                    R.id.events_fragment -> {
                        it.findNavController().navigate(
                            EventsFragmentDirections.actionEventsFragmentToDetailsFragment(eventId)
                        )
                    }
                    R.id.profile_fragment -> {
                        it.findNavController().navigate(
                            ProfileFragmentDirections.actionProfileFragmentToDetailsFragment(eventId)
                        )
                    }
                    else -> {
                        Toast.makeText(it.context, "Something went wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
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
        val event = shownDataset[position]

        val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat: DateFormat = SimpleDateFormat("hh:mm\ndd/MM/yyyy", Locale.getDefault())

        val date = inputFormat.parse(event.date) ?: Date()


        holder.timeDate.text = "Kl: ${outputFormat.format(date)}"
        holder.header.text = event.name
        //holder.timeDate.text = event.date
        holder.location.text = event.venue
        holder.price.text = "Kr. ${event.price},-"
        Picasso.with(holder.image.context).load(event.cover?.asset?.url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return shownDataset.size
    }

    fun swapDataset(newDataset: MutableList<Event>) {
        dataset = newDataset
        shownDataset = newDataset
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        var filteredList: List<Event>

        return object : Filter() {
            override fun performFiltering(input: CharSequence?): FilterResults {
                val charSearch = input.toString().lowercase()
                filteredList = if (charSearch.isEmpty()) {
                    dataset
                } else {
                    val resultList = mutableListOf<Event>()
                    for (event in dataset) {
                        if (event.name?.lowercase()?.contains(charSearch) == true) {
                            resultList.add(event)
                        }
                    }
                    resultList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList

                return filterResults
            }

            override fun publishResults(input: CharSequence?, results: FilterResults?) {
                shownDataset = results?.values as List<Event>
                notifyDataSetChanged()
            }

        }
    }
}
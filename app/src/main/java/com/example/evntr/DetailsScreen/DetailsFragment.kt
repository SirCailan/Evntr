package com.example.evntr.DetailsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.volley.toolbox.Volley
import com.example.evntr.API.Event
import com.example.evntr.R
import com.example.evntr.myEventsList
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment() {
    private val viewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs() //Parameters from nav_graph

    private lateinit var backButton: Button
    private lateinit var addButton: Button
    private lateinit var upperDivider: ImageView
    private lateinit var lowerDivider: ImageView
    private lateinit var loadingSpinner: ProgressBar

    private lateinit var eventImage: ImageView
    private lateinit var eventName: TextView
    private lateinit var eventTime: TextView
    private lateinit var eventVenue: TextView
    private lateinit var eventPrice: TextView
    private lateinit var eventHost: TextView
    private lateinit var eventType: TextView
    private lateinit var eventAgeLimit: TextView
    private lateinit var eventDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        backButton = view.findViewById(R.id.event_details_backbutton)
        addButton = view.findViewById(R.id.event_details_addbutton)
        upperDivider = view.findViewById(R.id.event_details_divider_1)
        lowerDivider = view.findViewById(R.id.event_details_divider_2)
        loadingSpinner = view.findViewById(R.id.event_details_progressbar)

        eventImage = view.findViewById(R.id.event_details_image)
        eventName = view.findViewById(R.id.event_details_header)
        eventTime = view.findViewById(R.id.event_details_time)
        eventVenue = view.findViewById(R.id.event_details_venue)
        eventPrice = view.findViewById(R.id.event_details_price)
        eventHost = view.findViewById(R.id.event_details_host)
        eventType = view.findViewById(R.id.event_details_type)
        eventAgeLimit = view.findViewById(R.id.event_details_agelimit)
        eventDescription = view.findViewById(R.id.event_details_description)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        val id = args.eventId

        viewModel.fetchEventDetails(Volley.newRequestQueue(context), id) { event ->
            if (event != null) {

                setAddButton(event)

                val imageUrl = event.image?.asset?.url

                Picasso.with(context).load(imageUrl).into(eventImage)

                enableVisibility()

                eventName.text = event.name
                eventTime.text = event.date
                eventVenue.text = event.venue
                eventPrice.text = "Kr. ${event.price},-"
                eventHost.text = event.host?.name //TODO, fix proper name for host
                eventType.text = event.category
                eventAgeLimit.text = event.ageLimit
                eventDescription.text = event.text
            }
        }
    }

    private fun enableVisibility() {
        addButton.visibility = View.VISIBLE
        upperDivider.visibility = View.VISIBLE
        lowerDivider.visibility = View.VISIBLE
        loadingSpinner.visibility = View.GONE
    }

    private fun setAddButton(event: Event) {

        addButton.setOnClickListener {

            myEventsList.add(event)

            addButton.text = "Added!"
            addButton.isClickable = false
        }
    }
}
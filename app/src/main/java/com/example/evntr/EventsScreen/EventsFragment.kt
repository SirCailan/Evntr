package com.example.evntr.EventsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.evntr.EventsAdapter
import com.example.evntr.R


class EventsFragment : Fragment() {
    private val viewModel: EventsViewModel by viewModels()

    private lateinit var backButton: Button
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: EventsAdapter
    private lateinit var loadingSpinner: ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingSpinner = view.findViewById(R.id.events_progressbar)

        myRecyclerView = view.findViewById(R.id.Event_RecylerView)
        myLayoutManager = LinearLayoutManager(activity)

        myRecyclerView.layoutManager = myLayoutManager
        
        viewModel.fetchAllEvents(Volley.newRequestQueue(context)) { events ->
            if (events != null) {
                myAdapter = EventsAdapter(events)

                loadingSpinner.visibility = View.GONE

                myRecyclerView.adapter = myAdapter
            }
        }

        backButton = view.findViewById(R.id.Event_Back_Button)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }


    }

}
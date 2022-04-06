package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley


class EventsFragment : Fragment() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: EventsAdapter
    private val viewModel: EventsViewHolder by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myRecyclerView = view.findViewById(R.id.Event_RecylerView)
        myLayoutManager = LinearLayoutManager(activity)

        myRecyclerView.layoutManager = myLayoutManager


        val eventsList = viewModel.getAllEvents(Volley.newRequestQueue(context)) { events ->
            if (events != null) {
                myAdapter = EventsAdapter(events)
                myRecyclerView.adapter = myAdapter
            }

        }




    }

}
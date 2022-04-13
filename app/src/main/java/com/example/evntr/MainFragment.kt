package com.example.evntr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment() {

    private lateinit var eventsButton: Button

    private lateinit var myAdapter: EventsAdapter
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventsButton = view.findViewById(R.id.mainscreen_event_button)

        myRecyclerView = view.findViewById(R.id.Event_RecylerView)
        myLayoutManager = LinearLayoutManager(activity)
        myRecyclerView.layoutManager = myLayoutManager

        //TODO: Add the list of events you're participating in to the adapter.
        //myAdapter = EventsAdapter()

        //myRecyclerView.adapter = myAdapter

        eventsButton.setOnClickListener {
           // event()
               //findNavController().navigate(MainFragmentDirections.actionMainFragmentToEventsFragment())
        }
    }
}
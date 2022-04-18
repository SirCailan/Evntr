package com.example.evntr.profilescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evntr.EventsAdapter
import com.example.evntr.R
import com.example.evntr.myEventsList


class ProfileFragment : Fragment() {


    private lateinit var myAdapter: EventsAdapter
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myRecyclerView = view.findViewById(R.id.profile_events_recyclerview)
        myLayoutManager = LinearLayoutManager(activity)
        myRecyclerView.layoutManager = myLayoutManager

        myAdapter = EventsAdapter(myEventsList)

        myRecyclerView.adapter = myAdapter
    }
}
package com.example.evntr.EventsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.evntr.API.Event
import com.example.evntr.EventsAdapter
import com.example.evntr.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class EventsFragment : Fragment() {
    private val viewModel: EventsViewModel by viewModels()

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var myAdapter: EventsAdapter
    private lateinit var loadingSpinner: ProgressBar
    private lateinit var sortSpinner: Spinner
    private lateinit var eventsFilter: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation)

        navView.visibility = View.VISIBLE //Makes bottom navigation bar visible

        sortSpinner = view.findViewById(R.id.events_sort_spinner)
        eventsFilter = view.findViewById(R.id.events_searchview)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.sort_array,
            android.R.layout.simple_spinner_item
        ).also { spinnerAdapter ->
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sortSpinner.adapter = spinnerAdapter
        }

        loadingSpinner = view.findViewById(R.id.events_progressbar)

        myRecyclerView = view.findViewById(R.id.Event_RecylerView)
        myLayoutManager = LinearLayoutManager(activity)

        myRecyclerView.layoutManager = myLayoutManager

        myAdapter = EventsAdapter(viewModel.retrieveEventsList())

        loadingSpinner.visibility = View.GONE

        myRecyclerView.adapter = myAdapter

        setEventsFilter()

        onSelectSpinnerItem()
    }

    private fun setEventsFilter() {
        eventsFilter.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(input: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(input: String?): Boolean {
                myAdapter.filter.filter(input)
                return false
            }

        } )
    }

    private fun onSelectSpinnerItem() {
        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent != null) {
                    viewModel.fetchAllEvents(
                        Volley.newRequestQueue(context),
                        sortBy = position
                    ) { success ->
                        if (success) {
                            myAdapter.swapDataset(viewModel.retrieveEventsList() as MutableList<Event>)
                            //myRecyclerView.scrollToPosition(0)
                        }
                    }
                }
            }

        }
    }

}